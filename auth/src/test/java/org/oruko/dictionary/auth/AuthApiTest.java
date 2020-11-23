package org.oruko.dictionary.auth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.oruko.dictionary.auth.rest.AuthApi;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests {@link AuthApi}
 * @author Dadepo Aderemi.
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthApiTest {

    @InjectMocks
    AuthApi authApi;

    @Mock
    ApiUserRepository apiUserRepository;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authApi).build();
    }


    @Test
    public void testGetAuthMetaData() throws Exception {
        when(apiUserRepository.count()).thenReturn(2L);
        mockMvc.perform(get("/v1/auth/meta"))
               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
               .andExpect(jsonPath("$.totalUsers",is(2)))
               .andExpect(status().isOk());
    }
}