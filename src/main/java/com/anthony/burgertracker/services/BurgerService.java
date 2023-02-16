package com.anthony.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthony.burgertracker.models.Burger;
import com.anthony.burgertracker.repository.BurgerRepository;



@Service
public class BurgerService {
  @Autowired BurgerRepository burgerRepository;

  // findAll returns an iterable. In our case we want to override this so we return a list of burgers
  public List<Burger> allBurgers() {
    return burgerRepository.findAll();
  }

  // void doesn't return anything
  public void createBurger(Burger burger) {
    burgerRepository.save(burger);
  }

  public Burger getOneBurger(Long id) {
    Optional<Burger> optionalBurger = burgerRepository.findById(id);
    return optionalBurger.orElse(null);
  }

  public void updateBurger(Burger burger) {
    burgerRepository.save(burger);
  }

  public void deleteBurger(Burger burger) {
    burgerRepository.delete(burger);
  }

}
