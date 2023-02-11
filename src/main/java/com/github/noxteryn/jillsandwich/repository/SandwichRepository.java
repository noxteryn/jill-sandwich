package com.github.noxteryn.jillsandwich.repository;

import com.github.noxteryn.jillsandwich.entity.Sandwich;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SandwichRepository extends CrudRepository<Sandwich, Long>
{
}
