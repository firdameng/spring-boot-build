package com.lagou.springboot_server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringbootServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServerApplication.class, args);
	}

}
