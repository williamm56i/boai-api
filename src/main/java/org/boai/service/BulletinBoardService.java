package org.boai.service;

import org.boai.controller.dto.BulletinBoardDto;
import org.boai.persistence.vo.BulletinBoard;
import org.boai.persistence.vo.manual.BulletinBoardVo;

import java.util.List;

public interface BulletinBoardService {

    List<BulletinBoardVo> getAll();

    List<BulletinBoardVo> getBulletinBoard(BulletinBoardDto dto);

    BulletinBoard getBulletinBoardDetail(String id);

    String createBulletinBoard(BulletinBoardDto dto);

    String modifyBulletinBoard(BulletinBoardDto dto);

    String removeBulletinBoard(String id);
}
