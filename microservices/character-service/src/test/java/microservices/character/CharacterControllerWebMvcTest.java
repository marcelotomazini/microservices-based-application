package microservices.character;

import static microservices.character.CharacterTestUtils.newCharacter;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CharacterController.class)
public class CharacterControllerWebMvcTest {
	
	@Autowired private MockMvc mockMvc;
	@MockBean private CharacterService service;
	@MockBean private CharacterValidator validator;
	
	@Test
	public void requestCharactersWithEmptyDatabase() throws Exception {
		List<Character> characters = new ArrayList<>();
		characters.add(newCharacter());
		
		when(service.findAll()).thenReturn(characters);
		
		mockMvc
			.perform(get("/api/v1/characters"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString(
					"["
					+ "{\"id\":1,"
					+ "\"name\":\"name\","
					+ "\"role\":\"role\","
					+ "\"school\":\"school\","
					+ "\"house\":\"house\","
					+ "\"patronus\":\"patronus\"}]")));
	}
}
