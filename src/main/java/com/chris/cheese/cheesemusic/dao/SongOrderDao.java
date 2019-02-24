package com.chris.cheese.cheesemusic.dao;

import com.chris.cheese.cheesemusic.pojo.SongOrderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongOrderDao extends JpaRepository<SongOrderDO, Long> {

    List<SongOrderDO> findAllByUserIdOrderByPickTimeDesc(Long userId);

    List<SongOrderDO> findAllByPickStatus(String pickStatus);
}
