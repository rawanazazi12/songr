package com.course.songr;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.course.songr.Repository.AlbumRepository;
import com.course.songr.Repository.SongRepository;
import com.course.songr.controller.SongrController;
import com.course.songr.model.Album;
import com.course.songr.model.Song;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.client.match.ContentRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IntegrationTest {

    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @AutoConfigureMockMvc
    class helloWorldRouteTest {
        @Autowired
        private MockMvc mockMvc;
        @Autowired
        SongrController songrControllerTest;

        @Autowired
        private AlbumRepository albumRepository;

        @Autowired
        private SongRepository songRepository;
        @Autowired
        TestRestTemplate testRestTemplate;
        @Autowired
        private ObjectMapper objectMapper;

        @Test
        void createNewPostWorksThroughAllLayers() throws Exception {
            String title = "this is acting";
            String artist = "Sia";
            int songCount = 12;
            long length = 1800;
            String imgUrl = "https://m.media-amazon.com/images/I/81q5xu21PaL.jpg";

            Album album = new Album(title,artist,songCount,length,imgUrl );
            albumRepository.save(album);
            Song song = new Song("unstoppable",180,10,album);

//            mockMvc.perform(song("/songs")
//                            .contentType("application/json")
//                            .content(objectMapper.writeValueAsString(song)))
//                    .andExpect(status().isOk());
//
//            Song foundSong = songRepository.findAllByAlbum_Title("").orElseThrow();
//            Assertions.assertEquals(song.getAlbum().getTitle(), foundSong.getAlbum().getTitle());
        }


    }



}
