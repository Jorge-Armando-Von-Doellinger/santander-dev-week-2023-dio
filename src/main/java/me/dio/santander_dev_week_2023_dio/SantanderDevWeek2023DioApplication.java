package me.dio.santander_dev_week_2023_dio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@OpenAPIDefinition(servers ={ @Server (url = "/", description = "Default Server URL")})
@SpringBootApplication
public class SantanderDevWeek2023DioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantanderDevWeek2023DioApplication.class, args);
	}

}
