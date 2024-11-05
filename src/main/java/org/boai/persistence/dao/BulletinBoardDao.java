package org.boai.persistence.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.boai.persistence.vo.BulletinBoard;
import org.boai.persistence.vo.manual.BulletinBoardVo;

import java.util.List;

@Mapper
public interface BulletinBoardDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BulletinBoard row);

    int insertSelective(BulletinBoard row);

    BulletinBoard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BulletinBoard row);

    int updateByPrimaryKey(BulletinBoard row);

    List<BulletinBoardVo> selectEnable();

    List<BulletinBoardVo> selectBySubject(@Param("subject") String subject);
}

