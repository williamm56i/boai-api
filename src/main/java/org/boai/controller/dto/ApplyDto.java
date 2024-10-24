package org.boai.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplyDto {

    BigDecimal activityId;

    String applyName;

    String applySex;

    String applyPhone;

    String applyEmail;

    String applyResidence;

    String infoFrom;

    String introducerName;
}
