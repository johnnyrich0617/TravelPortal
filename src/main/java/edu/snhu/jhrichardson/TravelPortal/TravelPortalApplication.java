package edu.snhu.jhrichardson.TravelPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TravelPortalApplication extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TravelPortalApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(TravelPortalApplication.class, args);
	}

}
