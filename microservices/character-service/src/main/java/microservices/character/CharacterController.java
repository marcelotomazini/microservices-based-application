package microservices.character;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/v1/")
public class CharacterController {

	@Autowired private CharacterService service;
	@Autowired private CharacterValidator validator;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

	@GetMapping("/characters")
	public List<Character> retrieveAllCharacters() {
		return service.findAll();
	}

	@GetMapping("/characters/{id}")
	public Character retrieveCharacter(@PathVariable long id) {
		Optional<Character> character = service.findById(id);

		if (!character.isPresent())
			throw new RuntimeException("Character not found: " + id);

		return character.get();
	}

	@DeleteMapping("/characters/{id}")
	public void deleteCharacter(@PathVariable long id) {
		service.deleteById(id);
	}

	@PostMapping("/characters")
	public ResponseEntity<Object> createCharacter(@RequestBody @Valid Character character) {
		Character savedCharacter = service.save(character);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCharacter.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/characters/{id}")
	public ResponseEntity<Object> updateCharacter(@RequestBody Character character, @PathVariable long id) {
		Optional<Character> characterOptional = service.findById(id);

		if (!characterOptional.isPresent())
			return ResponseEntity.notFound().build();

		character.setId(id);
		service.save(character);

		return ResponseEntity.noContent().build();
	}
}
