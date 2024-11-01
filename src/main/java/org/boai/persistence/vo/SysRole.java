package org.boai.persistence.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    private String roleId;

    private String roleName;

    private String createId;

    private Date createDate;

    private String updateId;

    private Date updateDate;
}