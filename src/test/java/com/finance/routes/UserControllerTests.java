/*package com.finance.routes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.finance.model.User;
import com.finance.repository.UserRepository;
import com.finance.service.AccountService;
import com.finance.service.JwtService;
import com.finance.service.UserService;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private SecurityContext securityContext;

    @MockBean
    private Authentication authentication;

    @MockBean
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        mockUserRepository = mock(UserRepository.class);
        UserService mockUserService = new UserService(mockUserRepository);
        UserController controller = new UserController(mockUserService);
        /*when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void savedUser() {
      User user = new User("zaphod", "zaphod@mail.com");
      User savedUser = mockUserRepository.save(user);
        assertThat(savedUser.getUsername()).isNotNull();
    }

   /*@Test
    @WithMockUser
    void testAuthenticatedUser() throws Exception {
        User mockUser = new User(); // Set properties as needed
        mockUser.setFullName("testUser");
        
        when(authentication.getPrincipal()).thenReturn(mockUser);

        mockMvc.perform(get("/users/me")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("testUser"));
    }

    @Test
    @WithMockUser
    void testAllUsers() throws Exception {
        User user1 = new User(); // Configure User details
        User user2 = new User();
        user1.setFullName("user1");
        user2.setFullName("user2");
        
        when(userService.allUsers()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(get("/users/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("user1"))
                .andExpect(jsonPath("$[1].username").value("user2"));
    }
}*/