package com.course.songr;

import com.course.songr.model.Album;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void albumConstructorTest(){
		Album album = new Album("title","artist",1000,10,"");
		album.setTitle("Mohtammah bl tafaseel");
		Assertions.assertEquals("Mohtammah bl tafaseel",album.getTitle());
		album.setArtist("Assalah Nasri");
		Assertions.assertEquals("Assalah Nasri",album.getArtist());
		album.setSongCount(16);
		Assertions.assertEquals(16,album.getSongCount());
		album.setLength(1800);
		Assertions.assertEquals(1800 , album.getLength());
	}

}
