package com.anthony.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anthony.burgertracker.services.BurgerService;
import com.anthony.burgertracker.models.Burger;

@Controller
public class MainController {

  @Autowired
  BurgerService burgerService;

  // ************** CREATE BURGER ***************** */
  // data binding -- allows for automatically writing the form data into a new
  // object
  // this binds the object to the JSP page using the view model (Model model) and
  // we don't have to manually create a book using @RequestParam
  @RequestMapping("/")
  public String newBurger(@ModelAttribute("burger") Burger burger, Model model) {
    List<Burger> burgers = burgerService.allBurgers();
    System.out.println(burgers);
    model.addAttribute("burgers", burgers);

    return "index.jsp";
  }

  @PostMapping("/burgers")
  public String createBurger(
      // valid declared first, binding result after attribute
      @Valid @ModelAttribute("burger") Burger burger,
      BindingResult result) {
    if (result.hasErrors()) {
      return "index.jsp";
    } else {
      burgerService.createBurger(burger);
    }
    return "redirect:/";

  }

  // ***************** EDIT/UPDATE BURGER ****************

  // this routesends you to the burgers/edit page by burger id
  @GetMapping("/burgers/edit/{id}")
  public String edit(@PathVariable("id") Long id, Model model) {
    Burger burger = burgerService.getOneBurger(id);
    model.addAttribute("burger", burger);
    return "edit.jsp";
  }

  // this route edits the burger by id
  @PutMapping("/burgers/{id}")
  public String update(@ModelAttribute("burger") Burger burger) {
    burgerService.updateBurger(burger);
    return "redirect:/";
  }

  // ************ DELETE BURGER **************
  @DeleteMapping("/burgers/{id}")
  public String deleteBurger(@PathVariable("id") Long id) {
    Burger burger = burgerService.getOneBurger(id);
    burgerService.deleteBurger(burger);
    return "redirect:/";
  }

}
