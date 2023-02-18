package com.github.noxteryn.jillsandwich.service;

import com.github.noxteryn.jillsandwich.entity.Sandwich;
import java.util.List;

public interface SandwichService
{
	List<Sandwich> listSandwiches();
	Sandwich findSandwich(Long id);
}
