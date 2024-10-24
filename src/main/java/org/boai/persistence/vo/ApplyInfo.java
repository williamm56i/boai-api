package org.boai.persistence.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ApplyInfo {

    BigDecimal id;

    BigDecimal activityId;

    String applyName;

    String applySex;

    String applyPhone;

    String applyEmail;

    String applyResidence;

    String infoFrom;

    String introducerName;

    Date applyDate;

    String memo;
}
