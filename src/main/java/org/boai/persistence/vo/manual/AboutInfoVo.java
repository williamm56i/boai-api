package org.boai.persistence.vo.manual;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AboutInfoVo {

    BigDecimal id;

    String title;

    String subtitle;

    String enable;
}
