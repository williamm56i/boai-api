package org.boai.persistence.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.boai.persistence.vo.ManagerInfo;
import org.boai.persistence.vo.manual.ManagerInfoVo;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ManagerInfoDao {


    /**
     * 查詢全部
     *
     * @return list
     */
    List<ManagerInfo> selectAll();

    /**
     * 以姓名查詢
     *
     * @param name 姓名
     * @return list
     */
    List<ManagerInfoVo> selectByName(@Param("name") String name);

    /**
     * 以主鍵查詢
     *
     * @param id 主鍵
     * @return managerInfo
     */
    ManagerInfo selectByPrimaryKey(@Param("id") BigDecimal id);

    /**
     * 建立關於資訊
     *
     * @param managerInfo 經營團隊資訊
     * @return int
     */
    int insert(ManagerInfo managerInfo);

    int insertSelective(ManagerInfo managerInfo);

    int updateByPrimaryKeySelective(ManagerInfo managerInfo);

    int deleteByPrimaryKey(@Param("id") BigDecimal id);

    String selectImageByPrimaryKey(@Param("id") BigDecimal id);
}
