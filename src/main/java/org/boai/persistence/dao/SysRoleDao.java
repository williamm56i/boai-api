package org.boai.persistence.dao;

import org.apache.ibatis.annotations.Mapper;
import org.boai.persistence.vo.SysRole;

@Mapper
public interface SysRoleDao {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole row);

    int insertSelective(SysRole row);

    SysRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRole row);

    int updateByPrimaryKey(SysRole row);
}