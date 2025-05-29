package org.boai.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.boai.persistence.dao.SysCodeDao;
import org.boai.persistence.dao.SysRelUserRoleDao;
import org.boai.persistence.dao.SysUserDao;
import org.boai.persistence.vo.SysCode;
import org.boai.persistence.vo.SysUser;
import org.boai.service.SystemService;
import org.boai.utils.HttpUtils;
import org.boai.utils.JasyptUtils;
import org.boai.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.boai.utils.JasyptUtils.decrypt;

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
    @Value("${jasypt.encryptor.password}")
    String decryptCode;

    @Override
    public String getTest(String name) {
        return "hello world! " + name;
    }

    @Override
    public String generateToken(String account, String password) {
        SysUser sysUser = sysUserDao.selectByPrimaryKey(account);
        if (sysUser != null) {
            if (!StringUtils.equals(account, "GUEST")) {
                String pwd = sysUser.getPassword();
                String code = JasyptUtils.decrypt(pwd, decryptCode);
                if (!StringUtils.equals(password, code)) {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                }
            } else {
                countVisitor();
            }
            List<String> roleList = sysRelUserRoleDao.selectRole(account);
            return JwtUtils.generate(account, roleList, tokenExpireTime);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
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

    private void countVisitor() {
        SysCode sysCode = sysCodeDao.selectByPrimaryKey("WEB", "VISITOR");
        if (sysCode == null) {
            sysCode = new SysCode();
            sysCode.setSysGroup("WEB");
            sysCode.setSysName("VISITOR");
            sysCode.setSysValue("1");
            sysCode.setCreateId("SYS");
            sysCode.setCreateDate(new Date());
            sysCodeDao.insert(sysCode);
        } else {
            int count = Integer.parseInt(sysCode.getSysValue());
            count++;
            sysCode.setSysValue(String.valueOf(count));
            sysCode.setUpdateId("SYS");
            sysCode.setUpdateDate(new Date());
            sysCodeDao.updateByPrimaryKeySelective(sysCode);
        }
    }
}
