package org.boai.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.boai.controller.dto.AboutInfoDto;
import org.boai.persistence.dao.AboutInfoDao;
import org.boai.persistence.vo.AboutInfo;
import org.boai.security.BoaiUserDetailsService;
import org.boai.service.AboutInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AboutInfoServiceImpl implements AboutInfoService {

    @Autowired
    AboutInfoDao aboutInfoDao;
    @Autowired
    BoaiUserDetailsService userDetailsService;

    @Override
    public List<AboutInfo> getAboutInfo() {
        return aboutInfoDao.selectEnable();
    }

    @Override
    public String createAboutInfo(AboutInfoDto dto) {
        String currentId = userDetailsService.getUsername();
        AboutInfo aboutInfo = new AboutInfo();
        BeanUtils.copyProperties(dto, aboutInfo);
        aboutInfo.setCreateId(currentId);
        aboutInfo.setCreateDate(new Date());
        aboutInfoDao.insert(aboutInfo);
        return "建立成功";
    }
}
