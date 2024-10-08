package org.boai.controller;

import org.boai.annotation.Pims;
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
    @GetMapping("/generateToken")
    public String generateToken(@RequestParam("account") String account) {
        return systemService.generateToken(account);
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
}
