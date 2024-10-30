package org.boai.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.boai.controller.dto.ApplyDto;
import org.boai.persistence.dao.ActivityInfoDao;
import org.boai.persistence.dao.ApplyInfoDao;
import org.boai.persistence.vo.ApplyInfo;
import org.boai.service.ApplyInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ApplyInfoServiceImpl implements ApplyInfoService {

    @Autowired
    ApplyInfoDao applyInfoDao;

    @Override
    public String apply(ApplyDto dto) {
        ApplyInfo applyInfo = new ApplyInfo();
        BeanUtils.copyProperties(dto, applyInfo);
        applyInfo.setApplyDate(new Date());
        applyInfoDao.insertSelective(applyInfo);
        return "報名成功";
    }

    @Override
    public String checkApplyStatus(ApplyDto dto) {
        List<ApplyInfo> applyInfoList = applyInfoDao.selectApplyInfo(dto.getActivityId(), dto.getApplyName());
        return applyInfoList.size() > 0 ? dto.getApplyName() + " 報名成功" : null;
    }

    @Override
    public List<ApplyInfo> getActivityApplyInfo(BigDecimal activityId) {
        return applyInfoDao.selectApplyInfo(activityId, null);
    }
}
