package com.github.noxteryn.jillsandwich.entity;

import jakarta.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Sandwich
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name is mandatory!")
	private String name;
	@NotBlank(message = "Recipe is mandatory!")
	private String recipe;

	public Sandwich()
	{
	}

	public Sandwich(String name, String recipe)
	{
		this.name = name;
		this.recipe = recipe;
	}

	@Override
	public String toString()
	{
		return "Sandwich{" +
				"id=" + id +
				", name='" + name + '\'' +
				", recipe='" + recipe + '\'' +
				'}';
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getRecipe()
	{
		return recipe;
	}

	public void setRecipe(String recipe)
	{
		this.recipe = recipe;
	}
}
