package com.learnWithAsif.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Rest API Documentation",
				description = "Best practice for creating REST API",
				version = "v1.0",
				contact = @Contact(
						name = "Md Asif Alam",
						email = "mdasifalam910@gmail.com",
						url="https://github.com/md-asif-alam/spring-boot-best-practices/tree/main/spring-boot-restful-webservices"

				),
				license = @License(
						name = "Apache",
						url = "https://github.com/md-asif-alam/spring-boot-best-practices/tree/main/spring-boot-restful-webservices"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Best Practice for REST API",
				url = "https://github.com/md-asif-alam/spring-boot-best-practices/tree/main/spring-boot-restful-webservices"
		)
)

public class SpringBootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestfulWebservicesApplication.class, args);
	}

}
