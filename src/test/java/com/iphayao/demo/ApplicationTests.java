package com.iphayao.demo;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

	@Test
	public void contextLoads() {
        userRepository.deleteAll();
	}

	@Test
    public void testGetDemoAddShoudReturnSaved() throws Exception {
	    this.mockMvc.perform(get("/demo/add?name=First&email=someemail@someemailprovider.com"))
                .andExpect(jsonPath("$").value("Saved"));
    }

    @Test
    public void testGetDemoGetAllShoudReturnSaved() throws Exception {
        this.mockMvc.perform(get("/demo/all"))
                .andExpect(jsonPath("$[0].name").value("First"));
    }

}
