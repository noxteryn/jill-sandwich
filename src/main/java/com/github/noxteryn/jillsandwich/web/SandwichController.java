package com.github.noxteryn.jillsandwich.web;

import com.github.noxteryn.jillsandwich.entity.Sandwich;
import com.github.noxteryn.jillsandwich.exception.SandwichNotFoundException;
import com.github.noxteryn.jillsandwich.repository.SandwichRepository;
import com.github.noxteryn.jillsandwich.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("jill")
public class SandwichController
{
	private SandwichService sandwichService;
	private final SandwichRepository sandwichRepository;

	public SandwichController(SandwichRepository sandwichRepository)
	{
		this.sandwichRepository = sandwichRepository;
	}

	@Autowired
	public void setSandwichService(SandwichService sandwichService)
	{
		this.sandwichService = sandwichService;
	}
	@GetMapping("sandwiches")
	public ResponseEntity<List<Sandwich>> getAllSandwiches()
	{
		List<Sandwich> list = sandwichService.listSandwiches();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("sandwiches/{id}")
	public ResponseEntity<Sandwich> getSandwich(@PathVariable("id") Long id)
	{
		try
		{
			return new ResponseEntity<>(sandwichService.findSandwich(id), HttpStatus.OK);
		}
		catch (SandwichNotFoundException exception)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sandwich Not Found");
		}
	}
	@PostMapping("sandwiches")
	@ResponseStatus(HttpStatus.OK)
	public Sandwich createSandwich(@RequestBody Sandwich sandwich)
	{
		return sandwichRepository.save(sandwich);
	}
	@PutMapping("sandwiches/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Sandwich updateSandwich(@PathVariable Long id, @RequestBody Sandwich newSandwich)
	{
		return sandwichRepository.findById(id)
				.map(sandwich -> {
					sandwich.setName(newSandwich.getName());
					sandwich.setRecipe(newSandwich.getRecipe());
					return sandwichRepository.save(sandwich);
				})
				.orElseGet(() -> {
					newSandwich.setId(id);
					return sandwichRepository.save(newSandwich);
				});
	}
	@DeleteMapping("sandwiches/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteSandwich(@PathVariable Long id)
	{
		sandwichRepository.deleteById(id); //TODO: Needs 404 Exception Handling.
	}
}
