package com.perfulandia.productservice;

import com.perfulandia.productservice.service.ProductoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PerfulandiaProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfulandiaProductoApplication.class, args);
	}


	//declarar el Bean
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
