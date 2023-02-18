package com.github.noxteryn.jillsandwich.repository;

import com.github.noxteryn.jillsandwich.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SandwichRepository extends JpaRepository<Sandwich, Long>
{
}
