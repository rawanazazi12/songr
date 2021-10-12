package com.course.songr.controller;

import com.course.songr.Repository.AlbumRepository;
import com.course.songr.Repository.SongRepository;
import com.course.songr.model.Album;
import com.course.songr.model.Song;
import com.course.songr.model.dto.SongDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class SongrController<album2, album1, album3, PostRepository> {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/hello")
        public String helloWorld(){
            return "hello";
        }

    @GetMapping("/capitalize/{input}")
    public String getCapitalizeName(@PathVariable String input, Model model) {
        model.addAttribute("name", input.toUpperCase());
        return "capitalize";
    }
//    @ResponseBody
//    @PostMapping("/albums")
//    public Album createNewPost(@RequestBody Album post) { // when working with json data
//        Album newAlbum = albumRepository.save(post);
//        return newAlbum;
//    }


        @GetMapping("/albums")
        public String getAlbums(Model album){
//            ArrayList<Album> albums = new ArrayList<Album>();
//            Album album1 = new Album("Ayam", "Tamer Ashour", 12, 2160, "https://i.ytimg.com/vi/b-oL0all7Tw/maxresdefault.jpg");
//            Album album2= new Album("Kol Yom Men Dah", "Mohamed Hamaki", 10, 1800, "https://images-na.ssl-images-amazon.com/images/I/41AO0ZpDiGL._SY445_SX342_QL70_ML2_.jpg");
//            Album album3= new Album("This Is Acting", "Sia", 16, 2880, "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/9fc5200a-b94d-4753-ac39-e98e7c9377f0/d9ahnd6-64d68e5d-bb0e-4ec1-9dfd-06cc7d24ec72.jpg/v1/fill/w_894,h_894,q_70,strp/sia___this_is_acting__cover_album__2015_by_jeanbox77_d9ahnd6-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTAyNCIsInBhdGgiOiJcL2ZcLzlmYzUyMDBhLWI5NGQtNDc1My1hYzM5LWU5OGU3YzkzNzdmMFwvZDlhaG5kNi02NGQ2OGU1ZC1iYjBlLTRlYzEtOWRmZC0wNmNjN2QyNGVjNzIuanBnIiwid2lkdGgiOiI8PTEwMjQifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.7NcmzcRblk6G9eUCK-86hJQLb-JPN9PNLdVUmy_h2H0");
//            albums.add(album1);
//            albums.add(album2);
//            albums.add(album3);
            album.addAttribute("albums", albumRepository.findAll());
            return "albums";
        }


        @PostMapping("/albums")
        public RedirectView createNewAlbum(@ModelAttribute Album album){
            albumRepository.save(album);
        return new RedirectView("albums");

        }

        @GetMapping("/songs")
        public String getSongsPage (Model model ){
        model.addAttribute("songs", songRepository.findAll());
        return "songs";
        }

        @PostMapping("/songs")
        public RedirectView addNewSong(@ModelAttribute SongDTO songDTO ){
            Album album = albumRepository.findByTitle(songDTO.getTitle()).orElseThrow();
            Song song = new Song(songDTO.getTitle(),songDTO.getSongLength(),songDTO.getTrackNum(),album);
            songRepository.save(song);
            return new RedirectView("songs");

        }


    @GetMapping("/songs/albums/{album}")
    public String findSongsByAlbum(@PathVariable  String title, Model model){
        List<Song> songs = songRepository.findAllByTitle(title);
        model.addAttribute("albumSong", songs);

        return "songsAlbum";
    }
    @GetMapping("/songs/{songId}")
    public String findSongBySongId(@PathVariable String songId, Model model) {
        Song song = songRepository.findById(Long.parseLong(songId)).orElseThrow();
        model.addAttribute("albumSong", song);

        return "song";
    }

    }






