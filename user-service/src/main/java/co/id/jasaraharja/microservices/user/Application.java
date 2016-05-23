package co.id.jasaraharja.microservices.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource;
import org.springframework.context.annotation.ComponentScan;

import co.id.jasaraharja.microservices.user.Application;

@EnableAutoConfiguration
@ComponentScan
@EnableOAuth2Resource
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
