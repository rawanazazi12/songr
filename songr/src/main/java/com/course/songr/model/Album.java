package com.course.songr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id" , nullable = false)
    private long id;
    String title;
    String artist;
    int songCount;
    long length;
    String imgUrl;

    @OneToMany(mappedBy = "album")
    private List<Song> addedSongs;


//    private timestamp;
    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern= "yyy-MM-dd HH:ss:ss")
    private LocalDateTime created ;


    public Album(String title, String artist, int songCount, long length, String imgUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imgUrl = imgUrl;
    }

    public Album(){

    }

//    public List<Song> getAddedSongs() {
//        return addedSongs;
//    }
//
//    public void setAddedSongs(List<Song> addedSongs) {
//        this.addedSongs = addedSongs;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


}
