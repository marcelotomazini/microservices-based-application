package microservices.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HouseService {

	@Autowired private RestTemplate restTemplate;
	@Autowired private ConfigProperties config;
	
	public boolean isValid(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", config.getKey());

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(headers);

		ResponseEntity<House[]> response = restTemplate.exchange(
				"http://us-central1-rh-challenges.cloudfunctions.net/potterApi/houses", 
				HttpMethod.GET, 
				entity, 
				House[].class);
		
		House[] houses = response.getBody();
		for(House house : houses)
			if(house.getId().equals(id))
				return true;
		
		return false;
	}
}
