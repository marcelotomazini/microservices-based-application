package microservices.character;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CharacterControllerServerTest { 
	
	@LocalServerPort private int port;
	@Autowired private CharacterController controller;
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
}