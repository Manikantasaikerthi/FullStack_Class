package com.klu.controller;
import org.springframework.web.bind.annotation.*;
@RestController
public class DemoController {
	@GetMapping("/hello")
	public String sayHello() {
		return "Spring Boot Demo Application";
	}
}
