package org.boai.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.boai.controller.dto.ApplyDto;
import org.boai.service.ApplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "報名資訊")
@RestController
@RequestMapping("/api/applyInfo")
public class ApplyInfoController {

    @Autowired
    ApplyInfoService applyInfoService;


    @Operation(summary = "報名")
    @PostMapping("/apply")
    public ResponseEntity<String> apply(@RequestBody ApplyDto dto) {
        return ResponseEntity.ok(applyInfoService.apply(dto));
    }

    @Operation(summary = "確認個人報名狀態")
    @PostMapping("/checkApplyStatus")
    public ResponseEntity<String> checkApplyStatus(@RequestBody ApplyDto dto) {
        return ResponseEntity.ok(applyInfoService.checkApplyStatus(dto));
    }
}
