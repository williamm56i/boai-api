package org.boai.persistence.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.boai.persistence.vo.AboutInfo;
import org.boai.persistence.vo.ApplyInfo;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ApplyInfoDao {

    int insert(ApplyInfo applyInfo);

    int insertSelective(ApplyInfo applyInfo);

    int countByActivityId(@Param("activityId") BigDecimal activityId);

    ApplyInfo selectApplyInfo(@Param("activityId") BigDecimal activityId, @Param("applyName") String applyName);
}
