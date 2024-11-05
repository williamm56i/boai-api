package org.boai.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.boai.controller.dto.BulletinBoardDto;
import org.boai.persistence.dao.BulletinBoardDao;
import org.boai.persistence.vo.manual.BulletinBoardVo;
import org.boai.service.BulletinBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BulletinBoardServiceImpl implements BulletinBoardService {

    @Autowired
    BulletinBoardDao bulletinBoardDao;

    @Override
    public List<BulletinBoardVo> getAll() {
        return bulletinBoardDao.selectEnable();
    }

    @Override
    public List<BulletinBoardVo> getBulletinBoard(BulletinBoardDto dto) {
        return bulletinBoardDao.selectBySubject(dto.getSubject());
    }
}
