package org.boai.service;

import com.github.pagehelper.PageInfo;
import org.boai.controller.dto.SysUserDto;
import org.boai.persistence.vo.SysUser;

public interface SysUserService {

    /**
     * 查詢使用者
     *
     * @param account 帳號
     * @return SysUser
     */
    SysUser getSysUser(String account);

    /**
     * 分頁查詢使用者
     *
     * @param dto 查詢條件
     * @return PageInfo
     */
    PageInfo<SysUser> paginateSysUser(SysUserDto dto);

    /**
     * 新增使用者
     *
     * @param dto 使用者
     */
    void createSysUser(SysUserDto dto);

    /**
     * 移除使用者
     *
     * @param account 帳號
     */
    void removeSysUser(String account);

    /**
     * 異動使用者
     *
     * @param dto 使用者
     */
    void modifySysUser(SysUserDto dto);
}
