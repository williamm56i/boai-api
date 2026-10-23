package org.boai.service;

import tools.jackson.core.JacksonException;
import org.boai.persistence.vo.SysCode;

import java.math.BigDecimal;
import java.util.List;

public interface SystemService {

    String getTest(String name);

    String generateToken(String account, String password);

    String refreshToken(String jwt);

    List<SysCode> getSysCodeAll();

    String getVisitorCount();

    String verifyRecaptcha(String token) throws JacksonException;
}
