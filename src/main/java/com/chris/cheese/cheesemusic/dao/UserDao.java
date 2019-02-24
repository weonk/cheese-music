package com.chris.cheese.cheesemusic.dao;

import com.chris.cheese.cheesemusic.pojo.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserDO, Long> {
    UserDO findByAccountAndPassword(String account, String password);

    UserDO findByAccount(String account);
}
