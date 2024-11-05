package org.boai.persistence.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BulletinBoard {
    private BigDecimal id;

    private Date announceDate;

    private String subject;

    private String contentData;

    private String createId;

    private Date createDate;

    private String updateId;

    private Date updateDate;

    private String enable;
}