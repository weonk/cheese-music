package com.chris.cheese.cheesemusic.service;

import com.chris.cheese.cheesemusic.dao.SongDao;
import com.chris.cheese.cheesemusic.dao.SongOrderDao;
import com.chris.cheese.cheesemusic.dao.UserDao;
import com.chris.cheese.cheesemusic.pojo.SongDO;
import com.chris.cheese.cheesemusic.pojo.SongOrderDO;
import com.chris.cheese.cheesemusic.pojo.SongQueryVo;
import com.chris.cheese.cheesemusic.util.SHAUtil;
import com.chris.cheese.cheesemusic.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SongOrderService {
    @Autowired
    private SongOrderDao songOrderDao;
    @Autowired
    private SongDao songDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;
    @Autowired
    private SongService songService;

    private final static String OLD_STATUS = "OLD_STATUS";
    private final static String NEW_STATUS = "NEW_STATUS";

    public void doSave(SongOrderDO songOrderDO, SongDO songDO) {
        songDao.save(songDO);
        songOrderDO.setId(snowflakeIdWorker.nextId());
        songOrderDO.setPickStatus(NEW_STATUS);
        songOrderDO.setPickTime(new Date());
        songOrderDao.save(songOrderDO);
    }

    public List<SongQueryVo> findByUserId(Long userId) {
        List<SongOrderDO> songOrderDOList = songOrderDao.findAllByUserIdOrderByPickTimeDesc(userId);
        if (songOrderDOList != null && songOrderDOList.size() > 0) {
            return doFill(songOrderDOList);
        } else {
            return null;
        }
    }

    public List<SongQueryVo> findByOld() {
        List<SongOrderDO> songOrderDOList = songOrderDao.findAllByPickStatusOrderByPickTimeDesc(OLD_STATUS);
        if (songOrderDOList != null && songOrderDOList.size() > 0) {
            return doFill(songOrderDOList);
        } else {
            return null;
        }
    }

    public List<SongQueryVo> findByNew() {
        List<SongOrderDO> songOrderDOList = songOrderDao.findAllByPickStatusOrderByPickTimeAsc(NEW_STATUS);
        if (songOrderDOList != null && songOrderDOList.size() > 0) {
            return doFill(songOrderDOList);
        } else {
            return null;
        }
    }

    public void doChangeStatus(Long songOrderId) {
        SongOrderDO songOrderDO = songOrderDao.findById(songOrderId).get();
        if (songOrderDO != null) {
            songOrderDO.setPickStatus(OLD_STATUS);
            songOrderDao.saveAndFlush(songOrderDO);
        }
    }

    public void doDelete(Long id) {
        songOrderDao.deleteById(id);
    }

    private List<SongQueryVo> doFill(List<SongOrderDO> songOrderDOList) {
        List<SongQueryVo> songQueryVoList = new ArrayList<>();
        songOrderDOList.forEach(item -> {
            SongQueryVo songQueryVo = new SongQueryVo();
            songQueryVo.setSongOrderDO(item);
            songQueryVo.setUserDO(userDao.findById(item.getUserId()).get());
            SongDO songDO = SongService.songTimeFormat(songService.getSingleSong(item.getSongId())).toSongDO();
            songQueryVo.setSongDO(songDO);
            songQueryVoList.add(songQueryVo);
        });
        return songQueryVoList;
    }
}
