package org.boai.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.boai.controller.dto.AboutInfoDto;
import org.boai.persistence.vo.AboutInfo;
import org.boai.service.AboutInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Operation(summary = "建立關於資訊")
    @PostMapping("/createAboutInfo")
    public ResponseEntity<String> createAboutInfo(AboutInfoDto dto) {
        return ResponseEntity.ok(aboutInfoService.createAboutInfo(dto));
    }
}
