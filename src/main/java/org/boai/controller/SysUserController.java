package org.boai.controller;

import com.github.pagehelper.PageInfo;
import org.boai.controller.dto.SysUserDto;
import org.boai.persistence.vo.SysUser;
import org.boai.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "使用者")
@RestController
@RequestMapping("/api/sysUser")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @Operation(summary = "查詢使用者")
    @PostMapping("/getSysUser")
    public ResponseEntity<SysUser> getSysUser(@RequestBody SysUserDto dto) {
        return ResponseEntity.ok(sysUserService.getSysUser(dto.getAccount()));
    }

    @Operation(summary = "分頁查詢使用者")
    @PostMapping("/paginateSysUser")
    public ResponseEntity<PageInfo<SysUser>> paginateSysUser(@RequestBody SysUserDto dto) {
        return ResponseEntity.ok(sysUserService.paginateSysUser(dto));
    }

    @Operation(summary = "新增使用者")
    @PostMapping("/createSysUser")
    public ResponseEntity<String> createSysUser(@RequestBody SysUserDto dto) {
        sysUserService.createSysUser(dto);
        return ResponseEntity.ok("新增成功");
    }

    @Operation(summary = "移除使用者")
    @DeleteMapping("/removeSysUser")
    public ResponseEntity<String> removeSysUser(@RequestBody SysUserDto dto) {
        sysUserService.removeSysUser(dto.getAccount());
        return ResponseEntity.ok("移除成功");
    }

    @Operation(summary = "異動使用者")
    @PutMapping("/modifySysUser")
    public ResponseEntity<String> modifySysUser(@RequestBody SysUserDto dto) {
        sysUserService.modifySysUser(dto);
        return ResponseEntity.ok("異動成功");
    }
}
