package br.com.compasso.cooperativismo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class CooperativismoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CooperativismoApplication.class, args);
	}

}
