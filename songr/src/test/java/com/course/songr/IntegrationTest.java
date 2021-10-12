package com.course.songr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

public class IntegrationTest {

    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @AutoConfigureMockMvc
    class helloWorldRouteTest {
        @Autowired
        private MockMvc mockMvc;
        @Autowired
        MainController mainControllerTest;
        @Autowired
        TestRestTemplate testRestTemplate;
        @LocalServerPort
        private int port;

        @Test
        public void testLoading() throws Exception {
            assertThat(mainControllerTest).isNotNull();
        }

    }

}
