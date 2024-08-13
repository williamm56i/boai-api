package org.boai.service;

import org.boai.controller.dto.AboutInfoDto;
import org.boai.persistence.vo.AboutInfo;

import java.util.List;

public interface AboutInfoService {

    List<AboutInfo> getAboutInfo();

    String createAboutInfo(AboutInfoDto dto);
}
