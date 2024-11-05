package org.boai.persistence.vo.manual;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BulletinBoardVo {

    BigDecimal id;

    Date announceDate;

    String subject;
}
