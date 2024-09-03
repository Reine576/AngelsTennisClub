package com.reine.AngelsTennisClub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.reine.AngelsTennisClub.service","com.reine.AngelsTennisClub.repository"})
public class AngelsTennisClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngelsTennisClubApplication.class, args);
	}

}
