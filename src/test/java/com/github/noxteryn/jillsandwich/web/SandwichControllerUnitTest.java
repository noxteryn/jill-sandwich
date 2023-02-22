package com.github.noxteryn.jillsandwich.web;

import com.github.noxteryn.jillsandwich.repository.SandwichRepository;
import com.github.noxteryn.jillsandwich.service.SandwichService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SandwichController.class)
public class SandwichControllerUnitTest
{
	@Autowired
	private MockMvc mvc;
	@Autowired
	@MockBean
	private SandwichRepository sandwichRepository;
	@MockBean
	private SandwichService sandwichService;

	@Test
	public void getAllSandwiches() throws Exception
	{
		 mvc.perform(get("/jill/sandwiches"))
				 .andExpect(status().isOk())
				 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
				 .andExpect(content().json("[]"));
		 verify(sandwichService, times(1)).listSandwiches();
	}
}
