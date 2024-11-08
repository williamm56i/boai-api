package org.boai.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.boai.controller.dto.AboutInfoDto;
import org.boai.persistence.vo.AboutInfo;
import org.boai.persistence.vo.manual.AboutInfoVo;
import org.boai.service.AboutInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "關於資訊")
@RestController
@RequestMapping("/api/aboutInfo")
public class AboutInfoController {

    @Autowired
    AboutInfoService aboutInfoService;

    @Operation(summary = "查詢生效中的關於我們圖卡資訊")
    @GetMapping("/getAll")
    public ResponseEntity<List<AboutInfoVo>> getAll() {
        return ResponseEntity.ok(aboutInfoService.getAll());
    }

    @Operation(summary = "查詢關於資訊")
    @PostMapping("/getAboutInfo")
    public ResponseEntity<List<AboutInfoVo>> getAboutInfo(@RequestBody AboutInfoDto dto) {
        return ResponseEntity.ok(aboutInfoService.getAboutInfo(dto));
    }

    @Operation(summary = "分頁查詢關於我們")
    @PostMapping("/paginateAboutInfo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<PageInfo<AboutInfo>> paginateAboutInfo(@RequestBody AboutInfoDto dto) {
        return ResponseEntity.ok(aboutInfoService.paginateAboutInfo(dto));
    }

    @Operation(summary = "查詢關於我們明細")
    @GetMapping("/getAboutInfoDetail/{id}")
    public ResponseEntity<AboutInfo> getAboutInfoDetail(@PathVariable String id) {
        return ResponseEntity.ok(aboutInfoService.getAboutInfoDetail(id));
    }

    @Operation(summary = "建立關於我們")
    @PostMapping("/createAboutInfo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> createAboutInfo(@RequestBody AboutInfoDto dto) {
        return ResponseEntity.ok(aboutInfoService.createAboutInfo(dto));
    }

    @Operation(summary = "異動關於我們")
    @PutMapping("/modifyAboutInfo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> modifyAboutInfo(@RequestBody AboutInfoDto dto) {
        return ResponseEntity.ok(aboutInfoService.modifyAboutInfo(dto));
    }

    @Operation(summary = "刪除關於資訊")
    @DeleteMapping("/removeAboutInfo/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> removeAboutInfo(@PathVariable String id) {
        return ResponseEntity.ok(aboutInfoService.removeAboutInfo(id));
    }

    @Operation(summary = "取得圖片")
    @GetMapping("/getImage/{id}")
    public ResponseEntity<String> getImage(@PathVariable String id) {
        return ResponseEntity.ok(aboutInfoService.getImage(id));
    }
}
