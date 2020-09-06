package co.uk.atlantis.dvsatestfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DvsaTestFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvsaTestFinderApplication.class, args);
	}

}
