package br.com.smiles.ClienteSmiles;

import br.com.smiles.ClienteSmiles.integration.entity.ClienteEntity;
import br.com.smiles.ClienteSmiles.integration.repository.ClienteRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ClienteSmilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteSmilesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("*");
			}
		};
	}


}
