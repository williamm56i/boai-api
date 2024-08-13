package org.boai.persistence.dao;

import org.apache.ibatis.annotations.Mapper;
import org.boai.persistence.vo.AboutInfo;

import java.util.List;

@Mapper
public interface AboutInfoDao {

    /**
     * 查詢生效的關於資訊
     *
     * @return list
     */
    List<AboutInfo> selectEnable();

    /**
     * 建立關於資訊
     *
     * @param aboutInfo 關於資訊
     * @return int
     */
    int insert(AboutInfo aboutInfo);
}
