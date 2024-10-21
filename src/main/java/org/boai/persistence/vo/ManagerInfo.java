package org.boai.persistence.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ManagerInfo {

    BigDecimal id;

    String title;

    String name;

    String image;

    String description1;

    String description2;

    String createId;

    Date createDate;

    String updateId;

    Date updateDate;
}
