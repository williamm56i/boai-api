package org.boai.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.boai.controller.dto.ActivityInfoDto;
import org.boai.controller.dto.ApplyDto;
import org.boai.persistence.dao.ActivityInfoDao;
import org.boai.persistence.dao.ApplyInfoDao;
import org.boai.persistence.vo.ActivityInfo;
import org.boai.persistence.vo.ApplyInfo;
import org.boai.security.BoaiUserDetailsService;
import org.boai.service.ActivityInfoService;
import org.boai.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ActivityInfoServiceImpl implements ActivityInfoService {

    @Autowired
    ActivityInfoDao activityInfoDao;
    @Autowired
    ApplyInfoDao applyInfoDao;
    @Autowired
    BoaiUserDetailsService userDetailsService;

    @Override
    public List<ActivityInfo> getAll() {
        return activityInfoDao.selectAll();
    }

    @Override
    public List<ActivityInfo> getActivityInfo(ActivityInfoDto dto) {
        return activityInfoDao.selectByTitle(dto.getTitle());
    }

    @Override
    public ActivityInfo getActivityInfoDetail(String id) {
        return activityInfoDao.selectByPrimaryKey(new BigDecimal(id));
    }

    @Override
    public String createActivityInfo(ActivityInfoDto dto) {
        String currentId = userDetailsService.getUsername();
        ActivityInfo activityInfo = new ActivityInfo();
        BeanUtils.copyProperties(dto, activityInfo);
        activityInfo.setApplyStartDate(DateUtils.convertStartSecond(activityInfo.getApplyStartDate()));
        activityInfo.setApplyEndDate(DateUtils.convertEndSecond(activityInfo.getApplyEndDate()));
        activityInfo.setCreateId(currentId);
        activityInfo.setCreateDate(new Date());
        activityInfoDao.insertSelective(activityInfo);
        return "新增成功";
    }

    @Override
    public String modifyActivityInfo(ActivityInfoDto dto) {
        String currentId = userDetailsService.getUsername();
        ActivityInfo activityInfo = new ActivityInfo();
        BeanUtils.copyProperties(dto, activityInfo);
        activityInfo.setApplyStartDate(DateUtils.convertStartSecond(activityInfo.getApplyStartDate()));
        activityInfo.setApplyEndDate(DateUtils.convertEndSecond(activityInfo.getApplyEndDate()));
        activityInfo.setUpdateId(currentId);
        activityInfo.setUpdateDate(new Date());
        activityInfoDao.updateByPrimaryKeySelective(activityInfo);
        return "異動成功";
    }

    @Override
    public String removeActivityInfo(String id) {
        if (applyInfoDao.countByActivityId(new BigDecimal(id)) > 0) {
            return "已有報名資訊不可刪除";
        }
        activityInfoDao.deleteByPrimaryKey(new BigDecimal(id));
        return "刪除成功";
    }

    @Override
    public String apply(ApplyDto dto) {
        ApplyInfo applyInfo = new ApplyInfo();
        BeanUtils.copyProperties(dto, applyInfo);
        applyInfo.setApplyDate(new Date());
        applyInfoDao.insertSelective(applyInfo);
        return "報名成功";
    }

    @Override
    public ApplyInfo getApplyInfo(ApplyDto dto) {
        return applyInfoDao.selectApplyInfo(dto.getActivityId(), dto.getApplyName());
    }
}
