package org.boai.service;

import org.boai.controller.dto.ManagerInfoDto;
import org.boai.persistence.vo.ManagerInfo;

import java.util.List;

public interface ManagerInfoService {

    List<ManagerInfo> getAll();

    /**
     * Get Manager info
     *
     * @param dto params
     * @return list
     */
    List<ManagerInfo> getManagerInfo(ManagerInfoDto dto);

    /**
     * Get Manager info all columns
     *
     * @param id primary key
     * @return ManagerInfo
     */
    ManagerInfo getManagerInfoDetail(String id);

    /**
     * Create Manager info
     *
     * @param dto new info
     * @return string
     */
    String createManagerInfo(ManagerInfoDto dto);

    /**
     * Modify Manager info
     *
     * @param dto modify params
     * @return string
     */
    String modifyManagerInfo(ManagerInfoDto dto);

    /**
     * Remove Manager info
     *
     * @param id primary key
     * @return string
     */
    String removeManagerInfo(String id);

    /**
     * get image by id
     *
     * @param id primary key
     * @return string
     */
    String getImage(String id);
}
