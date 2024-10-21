package org.boai.controller.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerInfoDto extends PageDto{

    BigDecimal id;

    String title;

    String name;

    String image;

    String description1;

    String description2;

}
