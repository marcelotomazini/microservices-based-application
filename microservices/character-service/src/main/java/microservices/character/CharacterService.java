package microservices.character;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterService {

	@Autowired private CharacterRepository characterRepository;
	@Autowired private RestTemplate restTemplate;

	public List<Character> findAll() {
		return characterRepository.findAll();
	}

	public Optional<Character> findById(long id) {
		return characterRepository.findById(id);
	}

	public void deleteById(long id) {
		characterRepository.deleteById(id);
	}

	public Character save(Character character) {
		return characterRepository.save(character);
	}

	public boolean isHouseValid(String house) {
		return restTemplate.getForObject("http://localhost:8080/api/house/" + house, String.class) != null;
	}
}
