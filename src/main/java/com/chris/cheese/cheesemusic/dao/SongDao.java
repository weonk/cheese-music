package com.chris.cheese.cheesemusic.dao;

import com.chris.cheese.cheesemusic.pojo.SongDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongDao extends JpaRepository<SongDO, String> {
}
