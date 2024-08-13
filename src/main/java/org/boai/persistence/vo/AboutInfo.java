package org.boai.persistence.vo;

import lombok.Data;

import java.util.Date;

@Data
public class AboutInfo {

    String id;

    String title;

    String subtitle;

    String image;

    String content;

    String enable;

    String createId;

    Date createDate;

    String updateId;

    Date updateDate;
}
