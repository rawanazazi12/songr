package com.course.songr.model.dto;

public class SongDTO {

  private String title ;
  private long songLength ;
  private int trackNum;
  private String album;

    public SongDTO(String title, long songLength, int trackNum, String album) {
        this.title = title;
        this.songLength = songLength;
        this.trackNum = trackNum;
        this.album = album;
    }

    public SongDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getSongLength() {
        return songLength;
    }

    public void setSongLength(long songLength) {
        this.songLength = songLength;
    }

    public int getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(int trackNum) {
        this.trackNum = trackNum;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
