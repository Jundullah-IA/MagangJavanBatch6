package com.tugas2.KalkulatorSederhana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.tugas2.KalkulatorSederhana"})
public class KalkulatorSederhanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KalkulatorSederhanaApplication.class, args);
	}

}
