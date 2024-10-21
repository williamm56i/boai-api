package org.boai.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.boai.controller.dto.ManagerInfoDto;
import org.boai.persistence.vo.ManagerInfo;
import org.boai.persistence.vo.manual.ManagerInfoVo;
import org.boai.service.ManagerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "經營團隊")
@RestController
@RequestMapping("/api/managerInfo")
public class ManagerInfoController {

    @Autowired
    ManagerInfoService managerInfoService;

    @Operation(summary = "查詢經營團隊圖卡資訊")
    @GetMapping("/getAll")
    public ResponseEntity<List<ManagerInfo>> getAll() {
        return ResponseEntity.ok(managerInfoService.getAll());
    }

    @Operation(summary = "查詢經營團隊")
    @PostMapping("/getManagerInfo")
    public ResponseEntity<List<ManagerInfoVo>> getManagerInfo(@RequestBody ManagerInfoDto dto) {
        return ResponseEntity.ok(managerInfoService.getManagerInfo(dto));
    }

    @Operation(summary = "查詢經營團隊明細")
    @GetMapping("/getManagerInfoDetail")
    public ResponseEntity<ManagerInfo> getManagerInfoDetail(@RequestParam("id") String id) {
        return ResponseEntity.ok(managerInfoService.getManagerInfoDetail(id));
    }

    @Operation(summary = "建立經營團隊")
    @PostMapping("/createManagerInfo")
    public ResponseEntity<String> createManagerInfo(@RequestBody ManagerInfoDto dto) {
        return ResponseEntity.ok(managerInfoService.createManagerInfo(dto));
    }

    @Operation(summary = "異動經營團隊")
    @PutMapping("/modifyManagerInfo")
    public ResponseEntity<String> modifyManagerInfo(@RequestBody ManagerInfoDto dto) {
        return ResponseEntity.ok(managerInfoService.modifyManagerInfo(dto));
    }

    @Operation(summary = "刪除經營團隊")
    @DeleteMapping("/removeManagerInfo/{id}")
    public ResponseEntity<String> removeManagerInfo(@PathVariable String id) {
        return ResponseEntity.ok(managerInfoService.removeManagerInfo(id));
    }

    @Operation(summary = "取得圖片")
    @GetMapping("/getImage/{id}")
    public ResponseEntity<String> getImage(@PathVariable String id) {
        return ResponseEntity.ok(managerInfoService.getImage(id));
    }
}
