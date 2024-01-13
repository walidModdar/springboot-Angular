package com.example.back_pdf;

import com.example.back_pdf.entity.Product;
import com.example.back_pdf.repository.ProductRepository;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackPdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackPdfApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProductRepository serverRepo) {
		return args -> {



		};
	}


}





