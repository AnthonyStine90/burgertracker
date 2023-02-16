package com.anthony.burgertracker.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anthony.burgertracker.models.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {


    List<Burger> findAll();
}