package com.generation.SpringSecurityJWT.controller;

import com.generation.SpringSecurityJWT.model.User;
import com.generation.SpringSecurityJWT.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Test
    @DisplayName("pruebas UserController")
    void saveTest(){
        UserService userService = mock(UserService.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);
        UserController userController = new UserController(userService, bCryptPasswordEncoder);

        User user = new User();
        user.setName("jessy");
        user.setUsername("jessy@gmail.com");
        user.setPassword("458556");

        when(userService.save(any(User.class))).thenReturn(user);
        User response = userController.saveUser(user);

        verify(userService, times(1)).save(any(User.class));
        verify(bCryptPasswordEncoder, atLeastOnce()).encode("458556");

        assertEquals(user.getName(), response.getName());
    }
    @Test
    @DisplayName("prueba de getUser")
    void getUserTest(){
        UserService userService = mock(UserService.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);
        UserController userController = new UserController(userService, bCryptPasswordEncoder);

        User user = new User();
        user.setName("jessi");
        user.setUsername("jessy@gmail.com");
        user.setPassword("458556");


        when(userService.save(any(User.class))).thenReturn(user);
        User response = userController.saveUser(user);

        verify(userService, times(1)).save(any(User.class));
        assertEquals(user.getName(), response.getName());
    }


}