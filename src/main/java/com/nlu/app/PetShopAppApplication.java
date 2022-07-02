package com.nlu.app;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.ServerResponse.Context;

import com.nlu.app.entity.CategoryEntity;
import com.nlu.app.entity.ProductEntity;
import com.nlu.app.repository.CategoryRepository;
import com.nlu.app.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class PetShopAppApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PetShopAppApplication.class, args);
		
		
	}
	@Bean
	public CommandLineRunner demo(CategoryRepository res) {
		return (args)-> {
			
			for (CategoryEntity pro : res.findAll()) {
                System.out.println(pro.toString());
            }
		};
	}

}
