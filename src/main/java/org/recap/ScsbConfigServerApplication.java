package org.recap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Bean;

@EnableConfigServer
@SpringBootApplication
public class ScsbConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScsbConfigServerApplication.class, args);
	}

       @Bean
       public  EnvironmentRepository environmentRepository() {
        return new CustomEnvironmentRepository();
       }
}
