package org.boai.service;

import org.boai.controller.dto.ActivityInfoDto;
import org.boai.controller.dto.ApplyDto;
import org.boai.persistence.vo.ActivityInfo;
import org.boai.persistence.vo.ApplyInfo;

import java.util.List;

public interface ActivityInfoService {

    List<ActivityInfo> getAll();

    List<ActivityInfo> getActivityInfo(ActivityInfoDto dto);

    ActivityInfo getActivityInfoDetail(String id);

    String createActivityInfo(ActivityInfoDto dto);

    String modifyActivityInfo(ActivityInfoDto dto);

    String removeActivityInfo(String id);

    String apply(ApplyDto dto);

    ApplyInfo getApplyInfo(ApplyDto dto);
}
