package org.humber.ClassroomSpringBootApp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_Index_route() throws Exception {
        mockMvc.perform(get("/a"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("message", "numbers"))
                .andExpect(model().attribute("message", "Hello World"))
                .andExpect(model().attribute("numbers", Arrays.asList(1, 2, 3, 4, 5)))
                .andExpect(view().name("index"));
    }

    @Test
    void test_Home_route() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello world"));
    }

    @Test
    void test_post_mapping() throws Exception {
        mockMvc.perform(post("/save1"))
                .andExpect(status().isOk())
                .andExpect(view().name("response"));
    }
}
