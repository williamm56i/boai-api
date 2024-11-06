package org.boai.persistence.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.boai.persistence.vo.BulletinBoard;
import org.boai.persistence.vo.manual.BulletinBoardVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Mapper
public interface BulletinBoardDao {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(BulletinBoard row);

    int insertSelective(BulletinBoard row);

    BulletinBoard selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(BulletinBoard row);

    int updateByPrimaryKey(BulletinBoard row);

    List<BulletinBoardVo> selectEnable(@Param("sysDate") Date sysDate);

    List<BulletinBoardVo> selectBySubject(@Param("subject") String subject);
}

