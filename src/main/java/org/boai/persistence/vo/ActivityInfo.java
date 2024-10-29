package org.boai.persistence.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ActivityInfo {

    BigDecimal id;

    String title;

    String subtitle;

    String content;

    Date applyStartDate;

    Date applyEndDate;

    String image;

    String activityGroup;

    Date activityDate;

    String createId;

    Date createDate;

    String updateId;

    Date updateDate;
}
