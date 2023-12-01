package com.varocode.springbootws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootwsApplication {


	@RequestMapping("/")
	String home(){
		return "Ivo bbb";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootwsApplication.class, args);
	}

}
