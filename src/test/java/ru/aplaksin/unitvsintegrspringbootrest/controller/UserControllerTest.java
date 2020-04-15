package ru.aplaksin.unitvsintegrspringbootrest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.aplaksin.unitvsintegrspringbootrest.model.User;
import ru.aplaksin.unitvsintegrspringbootrest.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getUserByIdTest() throws Exception {
        User user = new User();
        user.setName("John");
        user.setEmail("John@devt.com");
        user.setPhone("9658522233");
        user.setGender("Male");

        when(userService.getUserById(anyInt())).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/12"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("John@devt.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("9658522233"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("Male"))
                .andExpect(status().isOk());
    }

    @Test
    void saveUserTest() throws Exception{
        User user = new User();
        user.setId(1);
        user.setName("John");
        user.setEmail("John@devt.com");
        user.setPhone("965852262");
        user.setGender("Male");

        when(userService.saveUser(any(User.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/user/")
                .content(new ObjectMapper().writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("John@devt.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("965852262"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("Male"));
    }
}
