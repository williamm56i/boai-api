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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "關於資訊")
@RestController
@RequestMapping("/api/aboutInfo")
public class AboutInfoController {

    @Autowired
    AboutInfoService aboutInfoService;

    @Operation(summary = "查詢關於資訊")
    @GetMapping("/getAboutInfo")
    public ResponseEntity<List<AboutInfo>> getAboutInfo() {
        return ResponseEntity.ok(aboutInfoService.getAboutInfo());
    }

    @Operation(summary = "分頁查詢關於我們")
    @PostMapping("/paginateAboutInfo")
    public ResponseEntity<PageInfo<AboutInfoVo>> paginateAboutInfo(@RequestBody AboutInfoDto dto) {
        return ResponseEntity.ok(aboutInfoService.paginateAboutInfo(dto));
    }

    @Operation(summary = "查詢關於我們明細")
    @GetMapping("/getAboutInfoDetail")
    public ResponseEntity<AboutInfo> getAboutInfoDetail(@RequestParam("id") String id) {
        return ResponseEntity.ok(aboutInfoService.getAboutInfoDetail(id));
    }

    @Operation(summary = "建立關於資訊")
    @PostMapping("/createAboutInfo")
    public ResponseEntity<String> createAboutInfo(@RequestBody AboutInfoDto dto) {
        return ResponseEntity.ok(aboutInfoService.createAboutInfo(dto));
    }

    @Operation(summary = "刪除關於資訊")
    @DeleteMapping("/removeAboutInfo/{id}")
    public ResponseEntity<String> removeAboutInfo(@PathVariable String id) {
        return ResponseEntity.ok(aboutInfoService.removeAboutInfo(id));
    }
}
