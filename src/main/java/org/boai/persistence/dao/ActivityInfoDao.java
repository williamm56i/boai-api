package org.boai.persistence.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.boai.persistence.vo.ActivityInfo;
import org.boai.persistence.vo.ApplyInfo;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ActivityInfoDao {

    List<ActivityInfo> selectAll();

    /**
     * 以主鍵查詢
     *
     * @param id 主鍵
     * @return aboutInfo
     */
    ActivityInfo selectByPrimaryKey(@Param("id") BigDecimal id);

    /**
     * 以主題查詢
     *
     * @param title 主題
     * @return list
     */
    List<ActivityInfo> selectByTitle(@Param("title") String title);

    /**
     * 建立活動資訊
     *
     * @param activityInfo 活動資訊
     * @return int
     */
    int insert(ActivityInfo activityInfo);

    int insertSelective(ActivityInfo activityInfo);

    int updateByPrimaryKeySelective(ActivityInfo activityInfo);

    int deleteByPrimaryKey(@Param("id") BigDecimal id);

    String selectImageByPrimaryKey(@Param("id") BigDecimal id);

}
