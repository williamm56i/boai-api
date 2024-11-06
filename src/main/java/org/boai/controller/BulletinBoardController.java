package org.boai.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.boai.controller.dto.BulletinBoardDto;
import org.boai.persistence.vo.BulletinBoard;
import org.boai.persistence.vo.manual.BulletinBoardVo;
import org.boai.service.BulletinBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "最新消息")
@RestController
@RequestMapping("/api/bulletinBoard")
public class BulletinBoardController {

    @Autowired
    BulletinBoardService bulletinBoardService;

    @Operation(summary = "查詢生效中的所有最新消息")
    @GetMapping("/getAll")
    public ResponseEntity<List<BulletinBoardVo>> getAll() {
        return ResponseEntity.ok(bulletinBoardService.getAll());
    }

    @Operation(summary = "查詢最新消息")
    @PostMapping("/getBulletinBoard")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<BulletinBoardVo>> getBulletinBoard(@RequestBody BulletinBoardDto dto) {
        return ResponseEntity.ok(bulletinBoardService.getBulletinBoard(dto));
    }

    @Operation(summary = "查詢最新消息明細")
    @GetMapping("/getBulletinBoardDetail/{id}")
    public ResponseEntity<BulletinBoard> getBulletinBoardDetail(@PathVariable String id) {
        return ResponseEntity.ok(bulletinBoardService.getBulletinBoardDetail(id));
    }

    @Operation(summary = "新增最新消息")
    @PostMapping("/createBulletinBoard")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> createBulletinBoard(@RequestBody BulletinBoardDto dto) {
        return ResponseEntity.ok(bulletinBoardService.createBulletinBoard(dto));
    }

    @Operation(summary = "異動最新消息")
    @PutMapping("/modifyBulletinBoard")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> modifyBulletinBoard(@RequestBody BulletinBoardDto dto) {
        return ResponseEntity.ok(bulletinBoardService.modifyBulletinBoard((dto)));
    }

    @Operation(summary = "刪除最新消息")
    @DeleteMapping("/removeBulletinBoard/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String>  removeBulletinBoard(@PathVariable String id) {
        return ResponseEntity.ok(bulletinBoardService.removeBulletinBoard(id));
    }
}
