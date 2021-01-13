package microservices.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class HouseController {

	@Autowired private HouseService service;
	
	@GetMapping("/house/{id}")
	public Boolean isValid(@PathVariable String id) {
		return service.isValid(id);
	}
}
