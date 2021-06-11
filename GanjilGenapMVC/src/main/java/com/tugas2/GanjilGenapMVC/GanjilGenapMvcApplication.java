package com.tugas2.GanjilGenapMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.tugas2.GanjilGenapMVC"})
public class GanjilGenapMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(GanjilGenapMvcApplication.class, args);
	}

}
