package microservices.house;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HouseController.class)
public class HouseControllerTest { 
	
	@Autowired private MockMvc mockMvc;
	@MockBean private HouseService service;
	
	@Test
	public void queryForValidHouse() throws Exception {
		expectResult(true);
	}

	@Test
	public void queryForInvalidHouse() throws Exception {
		expectResult(false);
	}
	
	private void expectResult(boolean result) throws Exception {
		when(service.isValid("1")).thenReturn(result);
		
		mockMvc
			.perform(get("/api/v1/house/1"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo(String.valueOf(result))));
	}

}