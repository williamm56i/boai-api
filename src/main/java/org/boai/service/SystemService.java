package org.boai.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.boai.persistence.vo.SysCode;

import java.util.List;

public interface SystemService {

    String getTest(String name);

    String generateToken(String account);

    String refreshToken(String jwt);

    List<SysCode> getSysCodeAll();

    String verifyRecaptcha(String token) throws JsonProcessingException;
}
