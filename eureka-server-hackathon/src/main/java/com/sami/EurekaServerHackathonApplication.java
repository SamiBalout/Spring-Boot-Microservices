package com.cgi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //Activates Eureka Server
public class EurekaServerHackathonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerHackathonApplication.class, args);
	}

}
