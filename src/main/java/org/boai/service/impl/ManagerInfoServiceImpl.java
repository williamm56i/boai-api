package org.boai.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.boai.controller.dto.ManagerInfoDto;
import org.boai.persistence.dao.ManagerInfoDao;
import org.boai.persistence.vo.ManagerInfo;
import org.boai.persistence.vo.manual.ManagerInfoVo;
import org.boai.security.BoaiUserDetailsService;
import org.boai.service.ManagerInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ManagerInfoServiceImpl implements ManagerInfoService {

    @Autowired
    ManagerInfoDao managerInfoDao;
    @Autowired
    BoaiUserDetailsService userDetailsService;

    @Override
    public List<ManagerInfo> getAll() {
        return managerInfoDao.selectAll();
    }

    @Override
    public List<ManagerInfoVo> getManagerInfo(ManagerInfoDto dto) {
        return managerInfoDao.selectByName(dto.getName());
    }

    @Override
    public ManagerInfo getManagerInfoDetail(String id) {
        return managerInfoDao.selectByPrimaryKey(new BigDecimal(id));
    }

    @Override
    public String createManagerInfo(ManagerInfoDto dto) {
        String currentId = userDetailsService.getUsername();
        ManagerInfo managerInfo = new ManagerInfo();
        BeanUtils.copyProperties(dto, managerInfo);
        managerInfo.setCreateId(currentId);
        managerInfo.setCreateDate(new Date());
        managerInfoDao.insertSelective(managerInfo);
        return "建立成功";
    }

    @Override
    public String modifyManagerInfo(ManagerInfoDto dto) {
        String currentId = userDetailsService.getUsername();
        ManagerInfo managerInfo = new ManagerInfo();
        BeanUtils.copyProperties(dto, managerInfo);
        managerInfo.setUpdateId(currentId);
        managerInfo.setUpdateDate(new Date());
        managerInfoDao.updateByPrimaryKeySelective(managerInfo);
        return "異動成功";
    }

    @Override
    public String removeManagerInfo(String id) {
        managerInfoDao.deleteByPrimaryKey(new BigDecimal(id));
        return "刪除成功";
    }

    @Override
    public String getImage(String id) {
        return managerInfoDao.selectImageByPrimaryKey(new BigDecimal(id));
    }
}
