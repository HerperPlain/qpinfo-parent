package com.qpinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class QpinfoAuthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QpinfoAuthApiApplication.class, args);
	}

	@RequestMapping(name = "/")
	public String index(){
		return "redirect:index.html";
	}
}
