package org.boai.persistence.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRelUserRoleDao {

    List<String> selectRole(@Param("account") String account);
}
