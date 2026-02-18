package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.service.CalcService;

@RestController
@RequestMapping("/calculator")
public class calcController {
	@Autowired
	private CalcService svc;
	
	//Addition - requestParam
	//URL: http://localhost:8080/calculator/add?a=10&b=5
	@RequestMapping("/add")
	public int add(@RequestParam int a,@RequestParam int b)
	{
		return svc.add(a, b);
	}
	
	//subtract - PathVariable
	//URL: http://localhost:8080/calculator/subtractor/
	@RequestMapping("/subtract/{a}/{b}") //at these place we have to give the value and the way to represent the path variable
	public int subtract(@PathVariable int a,@PathVariable int b)
	{
		return svc.subtract(a, b);
	}
//	path - multi
//	request  - division
	@RequestMapping("/multiply/{a}/{b}")
	public int multiply(@PathVariable int a,@PathVariable int b)
	{
		return svc.multiply(a, b);
	}
	@RequestMapping("/division")
	public double division(@RequestParam int a,@RequestParam int b)
	{
		return svc.division(a, b);
	}
	
	@RequestMapping("/module")
	public int module(@RequestParam int a,@RequestParam int b)
	{
		return svc.module(a, b);
	}
	
}