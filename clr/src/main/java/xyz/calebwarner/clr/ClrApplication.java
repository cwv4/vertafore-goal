package xyz.calebwarner.clr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import xyz.calebwarner.clr.service.ClrService;

@SpringBootApplication
public class ClrApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return args -> {
			ClrService clrService = new ClrService();

			clrService.getRooms(restTemplate);
			clrService.getStaff(restTemplate);
			clrService.getFizzBuzz(restTemplate);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ClrApplication.class, args);
	}

}
