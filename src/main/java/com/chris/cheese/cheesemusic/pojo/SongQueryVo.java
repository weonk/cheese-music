package com.chris.cheese.cheesemusic.pojo;

public class SongQueryVo {
    private UserDO userDO;
    private SongDO songDO;
    private SongOrderDO songOrderDO;

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public SongDO getSongDO() {
        return songDO;
    }

    public void setSongDO(SongDO songDO) {
        this.songDO = songDO;
    }

    public SongOrderDO getSongOrderDO() {
        return songOrderDO;
    }

    public void setSongOrderDO(SongOrderDO songOrderDO) {
        this.songOrderDO = songOrderDO;
    }
}
