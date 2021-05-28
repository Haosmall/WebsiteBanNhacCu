package com.websitenhaccu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
	@GetMapping("/error")
	public String test() {
		return "Error";
	}
}
