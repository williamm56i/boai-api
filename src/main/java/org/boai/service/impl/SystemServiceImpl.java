package org.boai.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;
import org.boai.persistence.dao.SysCodeDao;
import org.boai.persistence.dao.SysRelUserRoleDao;
import org.boai.persistence.dao.SysUserDao;
import org.boai.persistence.vo.SysCode;
import org.boai.service.SystemService;
import org.boai.utils.HttpUtils;
import org.boai.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SystemServiceImpl implements SystemService {

    @Autowired
    SysCodeDao sysCodeDao;
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    SysRelUserRoleDao sysRelUserRoleDao;
    @Autowired
    ObjectMapper objectMapper;
    @Value("${jwt.token-expire-time}")
    long tokenExpireTime;
    @Value("${recaptcha.recaptcha-verify-url}")
    String recaptchaVerifyUrl;
    @Value("${recaptcha.recaptcha-secret}")
    String recaptchaSecret;

    @Override
    public String getTest(String name) {
        return "hello world! " + name;
    }

    @Override
    public String generateToken(String account) {
        if (sysUserDao.selectByPrimaryKey(account) != null) {
            List<String> roleList = sysRelUserRoleDao.selectRole(account);
            return JwtUtils.generate(account, roleList, tokenExpireTime);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public String refreshToken(String jwt) {
        return JwtUtils.refresh(jwt, tokenExpireTime);
    }

    @Override
    public List<SysCode> getSysCodeAll() {
        return sysCodeDao.selectAll();
    }

    @Override
    public String verifyRecaptcha(String token) throws JsonProcessingException {
        String requestUrl = recaptchaVerifyUrl + "?secret=" + recaptchaSecret + "&response=" + token;
        String jsonResult = HttpUtils.post(requestUrl, null);
        log.info(jsonResult);
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        JavaType mapType = typeFactory.constructMapType(Map.class, String.class, Object.class);
        Map<String, Object> resultMap = objectMapper.readValue(jsonResult, mapType);
        boolean success = (boolean) resultMap.get("success");
        return success ? "SUCCESS" : "FAIL";
    }
}
