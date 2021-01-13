package microservices.character;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CharacterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CharacterApplication.class);
    }
    
    @Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
