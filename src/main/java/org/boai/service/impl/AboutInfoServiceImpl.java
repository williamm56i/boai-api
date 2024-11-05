package org.boai.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.boai.controller.dto.AboutInfoDto;
import org.boai.persistence.dao.AboutInfoDao;
import org.boai.persistence.vo.AboutInfo;
import org.boai.persistence.vo.manual.AboutInfoVo;
import org.boai.security.BoaiUserDetailsService;
import org.boai.service.AboutInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public List<AboutInfoVo> getAll() {
        return aboutInfoDao.selectEnable();
    }

    @Override
    public List<AboutInfoVo> getAboutInfo(AboutInfoDto dto) {
        return aboutInfoDao.selectByTitle(dto.getTitle());
    }

    @Override
    public PageInfo<AboutInfo> paginateAboutInfo(AboutInfoDto dto) {
        String sort = StringUtils.isNotEmpty(dto.getOrderString()) ? dto.getOrderString() : "ID asc";
        return PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), sort)
                .doSelectPageInfo(() -> aboutInfoDao.selectByTitle(dto.getTitle()));
    }

    @Override
    public AboutInfo getAboutInfoDetail(String id) {
        return aboutInfoDao.selectByPrimaryKey(new BigDecimal(id));
    }

    @Override
    public String createAboutInfo(AboutInfoDto dto) {
        String currentId = userDetailsService.getUsername();
        AboutInfo aboutInfo = new AboutInfo();
        BeanUtils.copyProperties(dto, aboutInfo);
        aboutInfo.setCreateId(currentId);
        aboutInfo.setCreateDate(new Date());
        aboutInfoDao.insertSelective(aboutInfo);
        return "建立成功";
    }

    @Override
    public String modifyAboutInfo(AboutInfoDto dto) {
        String currentId = userDetailsService.getUsername();
        AboutInfo aboutInfo = new AboutInfo();
        BeanUtils.copyProperties(dto, aboutInfo);
        aboutInfo.setUpdateId(currentId);
        aboutInfo.setUpdateDate(new Date());
        aboutInfoDao.updateByPrimaryKeySelective(aboutInfo);
        return "異動成功";
    }

    @Override
    public String removeAboutInfo(String id) {
        aboutInfoDao.deleteByPrimaryKey(new BigDecimal(id));
        return "刪除成功";
    }

    @Override
    public String getImage(String id) {
        return aboutInfoDao.selectImageByPrimaryKey(new BigDecimal(id));
    }
}
