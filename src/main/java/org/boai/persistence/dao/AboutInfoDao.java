package org.boai.persistence.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.boai.persistence.vo.AboutInfo;
import org.boai.persistence.vo.manual.AboutInfoVo;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface AboutInfoDao {

    /**
     * 查詢生效的關於資訊
     *
     * @return list
     */
    List<AboutInfoVo> selectEnable();

    /**
     * 以主題查詢
     *
     * @param title 主題
     * @return list
     */
    List<AboutInfoVo> selectByTitle(@Param("title") String title);

    /**
     * 以主鍵查詢
     *
     * @param id 主鍵
     * @return aboutInfo
     */
    AboutInfo selectByPrimaryKey(@Param("id") BigDecimal id);

    /**
     * 建立關於資訊
     *
     * @param aboutInfo 關於資訊
     * @return int
     */
    int insert(AboutInfo aboutInfo);

    int insertSelective(AboutInfo aboutInfo);

    int updateByPrimaryKeySelective(AboutInfo aboutInfo);

    int deleteByPrimaryKey(@Param("id") BigDecimal id);

    String selectImageByPrimaryKey(@Param("id") BigDecimal id);
}
