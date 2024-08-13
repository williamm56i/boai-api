package org.boai.service.impl;

import org.boai.persistence.dao.SysCodeDao;
import org.boai.persistence.dao.SysRelUserRoleDao;
import org.boai.persistence.dao.SysUserDao;
import org.boai.persistence.vo.SysCode;
import org.boai.service.SystemService;
import org.boai.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class SystemServiceImpl implements SystemService {

    @Autowired
    SysCodeDao sysCodeDao;
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    SysRelUserRoleDao sysRelUserRoleDao;

    @Override
    public String getTest(String name) {
        return "hello world! " + name;
    }

    @Override
    public String generateToken(String account) {
        if (sysUserDao.selectByPrimaryKey(account) != null) {
            List<String> roleList = sysRelUserRoleDao.selectRole(account);
            return JwtUtils.generate(account, roleList);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public String refreshToken(String jwt) {
        return JwtUtils.refresh(jwt);
    }

    @Override
    public List<SysCode> getSysCodeAll() {
        return sysCodeDao.selectAll();
    }
}
