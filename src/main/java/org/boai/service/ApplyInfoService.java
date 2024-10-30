package org.boai.service;

import org.boai.controller.dto.ApplyDto;
import org.boai.persistence.vo.ApplyInfo;

import java.util.List;

public interface ApplyInfoService {

    String apply(ApplyDto dto);

    String checkApplyStatus(ApplyDto dto);

    List<ApplyInfo> getActivityApplyInfo(String activityId);
}
