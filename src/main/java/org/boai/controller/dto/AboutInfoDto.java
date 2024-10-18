package org.boai.controller.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class AboutInfoDto extends PageDto{

    BigDecimal id;

    String title;

    String subtitle;

    String image;

    String content;

    String enable;
}
