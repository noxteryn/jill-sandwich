package com.github.noxteryn.jillsandwich.service;

import com.github.noxteryn.jillsandwich.entity.Sandwich;
import com.github.noxteryn.jillsandwich.exception.SandwichNotFoundException;
import com.github.noxteryn.jillsandwich.repository.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SandwichServiceImplementation implements SandwichService
{
	@Autowired
	private SandwichRepository sandwichRepository;
	@Override
	public List<Sandwich> listSandwiches()
	{
		return sandwichRepository.findAll();
	}
	@Override
	public Sandwich findSandwich(Long id)
	{
		Optional<Sandwich> optionalSandwich = sandwichRepository.findById(id);
		if (optionalSandwich.isPresent())
		{
			return optionalSandwich.get();
		}
		else
		{
			throw new SandwichNotFoundException("Sandwich Not Found");
		}
	}
}
