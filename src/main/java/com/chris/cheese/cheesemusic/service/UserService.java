package com.chris.cheese.cheesemusic.service;

import com.chris.cheese.cheesemusic.dao.UserDao;
import com.chris.cheese.cheesemusic.pojo.UserDO;
import com.chris.cheese.cheesemusic.util.SHAUtil;
import com.chris.cheese.cheesemusic.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public void signUp(UserDO userDO) {
        userDO.setPassword(SHAUtil.sha1(userDO.getPassword()));
        userDO.setId(snowflakeIdWorker.nextId());
        userDO.setCreateTime(new Date());
        userDO.setAccessLevel(0);
        userDao.save(userDO);
    }

    public UserDO signIn(UserDO userDO) {
        return userDao.findByAccountAndPassword(userDO.getAccount(), SHAUtil.sha1(userDO.getPassword()));
    }

    public UserDO findById(Long id) {
        return userDao.findById(id).get();
    }

    public void updatePassword(UserDO userDO) {
        userDao.save(userDO);
    }

    public UserDO findByAccount(UserDO userDO) {
        return userDao.findByAccount(userDO.getAccount());
    }
}
