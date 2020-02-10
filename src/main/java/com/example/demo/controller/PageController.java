package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "aloha";
	}

	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}

	@RequestMapping(value = { "/hello2", "/hello2/{name}" })
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}

	@RequestMapping("/calcu-convert/{bil1}/{bil2}")
	public String calcuConvert(@PathVariable Integer bil1, @PathVariable Integer bil2, Model model) {
		Integer hasil = bil1 + bil2;
		model.addAttribute("bil1", bil1);
		model.addAttribute("bil2", bil2);
		model.addAttribute("hasil", hasil);
		return "calcu-convert";
	}
}
