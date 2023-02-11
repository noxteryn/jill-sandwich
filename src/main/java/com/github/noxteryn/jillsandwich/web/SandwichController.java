package com.github.noxteryn.jillsandwich.web;

import com.github.noxteryn.jillsandwich.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SandwichController
{
	private SandwichService sandwichService;
	@Autowired
	public void setSandwichService(SandwichService sandwichService)
	{
		this.sandwichService = sandwichService;
	}
	@GetMapping("/sandwiches")
	public String readSandwich(Model model)
	{
		model.addAttribute("sandwiches", sandwichService.listSandwiches());
		return "sandwiches";
	}
}
