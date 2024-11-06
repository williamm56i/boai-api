package org.boai.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.boai.controller.dto.BulletinBoardDto;
import org.boai.persistence.dao.BulletinBoardDao;
import org.boai.persistence.vo.BulletinBoard;
import org.boai.persistence.vo.manual.BulletinBoardVo;
import org.boai.security.BoaiUserDetailsService;
import org.boai.service.BulletinBoardService;
import org.boai.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BulletinBoardServiceImpl implements BulletinBoardService {

    @Autowired
    BulletinBoardDao bulletinBoardDao;
    @Autowired
    BoaiUserDetailsService userDetailsService;

    @Override
    public List<BulletinBoardVo> getAll() {
        return bulletinBoardDao.selectEnable(new Date()).stream().sorted(Comparator.comparing(BulletinBoardVo::getAnnounceDate, Comparator.nullsLast(Comparator.reverseOrder()))).toList();
    }

    @Override
    public List<BulletinBoardVo> getBulletinBoard(BulletinBoardDto dto) {
        return bulletinBoardDao.selectBySubject(dto.getSubject()).stream().sorted(Comparator.comparing(BulletinBoardVo::getAnnounceDate, Comparator.nullsLast(Comparator.reverseOrder()))).toList();
    }

    @Override
    public BulletinBoard getBulletinBoardDetail(String id) {
        return bulletinBoardDao.selectByPrimaryKey(new BigDecimal(id));
    }

    @Override
    public String createBulletinBoard(BulletinBoardDto dto) {
        String currentId = userDetailsService.getUsername();
        BulletinBoard bulletinBoard = new BulletinBoard();
        BeanUtils.copyProperties(dto, bulletinBoard);
        bulletinBoard.setAnnounceDate(DateUtils.convertStartSecond(bulletinBoard.getAnnounceDate()));
        bulletinBoard.setCreateId(currentId);
        bulletinBoard.setCreateDate(new Date());
        bulletinBoardDao.insertSelective(bulletinBoard);
        return "建立成功";
    }

    @Override
    public String modifyBulletinBoard(BulletinBoardDto dto) {
        String currentId = userDetailsService.getUsername();
        BulletinBoard bulletinBoard = new BulletinBoard();
        BeanUtils.copyProperties(dto, bulletinBoard);
        bulletinBoard.setAnnounceDate(DateUtils.convertStartSecond(bulletinBoard.getAnnounceDate()));
        bulletinBoard.setUpdateId(currentId);
        bulletinBoard.setUpdateDate(new Date());
        bulletinBoardDao.updateByPrimaryKeySelective(bulletinBoard);
        return "異動成功";
    }

    @Override
    public String removeBulletinBoard(String id) {
        bulletinBoardDao.deleteByPrimaryKey(new BigDecimal(id));
        return "刪除成功";
    }
}
