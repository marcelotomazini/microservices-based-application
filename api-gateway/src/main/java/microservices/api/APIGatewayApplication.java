package microservices.api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableZuulProxy
public class APIGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(APIGatewayApplication.class);
	}
	
	@Bean
    public LogRequest logRequest() {
        return new LogRequest();
    }
}
