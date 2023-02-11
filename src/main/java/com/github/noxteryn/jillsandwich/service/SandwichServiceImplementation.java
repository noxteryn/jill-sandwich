package com.github.noxteryn.jillsandwich.service;

import com.github.noxteryn.jillsandwich.entity.Sandwich;
import com.github.noxteryn.jillsandwich.repository.SandwichRepository;
import com.github.noxteryn.jillsandwich.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichServiceImplementation implements SandwichService
{
	@Autowired
	private SandwichRepository sandwichRepository;
	@Override
	public Iterable<Sandwich> listSandwiches()
	{
		return sandwichRepository.findAll();
	}
}
