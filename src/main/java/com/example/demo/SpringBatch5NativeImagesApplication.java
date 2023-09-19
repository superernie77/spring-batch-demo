package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatch5NativeImagesApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBatch5NativeImagesApplication.class, args);
	  }

}
