package org.boai.controller.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AboutInfoDto extends PageDto{

    String id;

    String title;

    String subtitle;

    String image;

    String content;

    String enable;
}
