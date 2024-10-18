package org.boai.service;

import com.github.pagehelper.PageInfo;
import org.boai.controller.dto.AboutInfoDto;
import org.boai.persistence.vo.AboutInfo;
import org.boai.persistence.vo.manual.AboutInfoVo;

import java.util.List;

public interface AboutInfoService {

    List<AboutInfo> getAll();

    /**
     * Get about info
     *
     * @param dto params
     * @return list
     */
    List<AboutInfoVo> getAboutInfo(AboutInfoDto dto);

    /**
     * paginate search about info
     *
     * @param dto params
     * @return pageInfo
     */
    PageInfo<AboutInfoVo> paginateAboutInfo(AboutInfoDto dto);

    /**
     * Get about info all columns
     *
     * @param id primary key
     * @return aboutInfo
     */
    AboutInfo getAboutInfoDetail(String id);

    /**
     * Create about info
     *
     * @param dto new info
     * @return string
     */
    String createAboutInfo(AboutInfoDto dto);

    /**
     * Modify about info
     *
     * @param dto modify params
     * @return string
     */
    String modifyAboutInfo(AboutInfoDto dto);

    /**
     * Remove about info
     *
     * @param id primary key
     * @return string
     */
    String removeAboutInfo(String id);
}
