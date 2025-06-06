package org.boai.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.boai.annotation.Pims;
import org.boai.controller.dto.LoginDto;
import org.boai.persistence.vo.SysCode;
import org.boai.service.SystemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "系統")
@RestController
@RequestMapping("/api/system")
public class SystemController {

    @Autowired
    SystemService systemService;

    @Pims
    @Operation(summary = "GET測試")
    @GetMapping("/test")
    public ResponseEntity<String> getTest(@RequestParam("name") String name) {
        return ResponseEntity.ok(systemService.getTest(name));
    }

    @Operation(summary = "生成JWT")
    @PostMapping("/generateToken")
    public String generateToken(@RequestBody LoginDto dto) {
        return systemService.generateToken(dto.getAccount(), dto.getPassword());
    }

    @Operation(summary = "刷新JWT")
    @PostMapping("/refreshToken")
    public String refreshToken(@RequestBody String jwt) {
        return systemService.refreshToken(jwt);
    }

    @Operation(summary = "取得系統參數")
    @GetMapping("/getSysCodeAll")
    public ResponseEntity<List<SysCode>> getSysCodeAll() {
        return ResponseEntity.ok(systemService.getSysCodeAll());
    }

    @Operation(summary = "取得訪客人次")
    @GetMapping("/getVisitorCount")
    public ResponseEntity<String> getVisitorCount() {
        return ResponseEntity.ok(systemService.getVisitorCount());
    }

    @Operation(summary = "機器人驗證")
    @PostMapping("/verifyRecaptcha")
    public String verifyRecaptcha(@RequestParam("token") String token) throws JsonProcessingException {
        return systemService.verifyRecaptcha(token);
    }
}
