package org.boai.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BulletinBoardDto {

    BigDecimal id;

    String subject;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    Date announceDate;

    String contentData;

    String enable;
}
