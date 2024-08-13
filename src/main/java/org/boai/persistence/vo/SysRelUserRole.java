package org.boai.persistence.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SysRelUserRole {

    String account;

    String roleId;

    String createId;

    Date createDate;
}
