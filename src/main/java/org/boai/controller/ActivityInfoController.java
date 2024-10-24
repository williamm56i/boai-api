package org.boai.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.boai.controller.dto.ActivityInfoDto;
import org.boai.controller.dto.ApplyDto;
import org.boai.persistence.vo.ActivityInfo;
import org.boai.service.ActivityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "活動資訊")
@RestController
@RequestMapping("/api/activityInfo")
public class ActivityInfoController {

    @Autowired
    ActivityInfoService activityInfoService;

    @Operation(summary = "查詢所有活動資訊圖卡")
    @GetMapping("/getAll")
    public ResponseEntity<List<ActivityInfo>> getAll() {
        return ResponseEntity.ok(activityInfoService.getAll());
    }

    @Operation(summary = "查詢所有活動資訊")
    @PostMapping("/getActivityInfo")
    public ResponseEntity<List<ActivityInfo>> getActivityInfo(@RequestBody ActivityInfoDto dto) {
        return ResponseEntity.ok(activityInfoService.getActivityInfo(dto));
    }

    @Operation(summary = "查詢活動資訊明細")
    @GetMapping("/getActivityInfoDetail/{id}")
    public ResponseEntity<ActivityInfo> getActivityInfoDetail(@PathVariable String id) {
        return ResponseEntity.ok(activityInfoService.getActivityInfoDetail(id));
    }

    @Operation(summary = "新增活動資訊")
    @PostMapping("/createActivityInfo")
    public ResponseEntity<String> createActivityInfo(@RequestBody ActivityInfoDto dto) {
        return ResponseEntity.ok(activityInfoService.createActivityInfo(dto));
    }

    @Operation(summary = "異動活動資訊")
    @PutMapping("/modifyActivityInfo")
    public ResponseEntity<String> modifyActivityInfo(@RequestBody ActivityInfoDto dto) {
        return ResponseEntity.ok(activityInfoService.modifyActivityInfo(dto));
    }

    @Operation(summary = "刪除活動資訊")
    @DeleteMapping("/removeActivityInfo/{id}")
    public ResponseEntity<String> removeActivityInfo(@PathVariable String id) {
        return ResponseEntity.ok(activityInfoService.removeActivityInfo(id));
    }

    @Operation(summary = "報名")
    @PostMapping("/apply")
    public ResponseEntity<String> apply(@RequestBody ApplyDto dto) {
        return ResponseEntity.ok(activityInfoService.apply(dto));
    }
}
