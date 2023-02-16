package com.anthony.burgertracker.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "burgers")
public class Burger {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  
  @NotNull
  @Size(min = 2, max = 100, message="include burger name")
  private String name;

  @NotNull
  @Size(min = 2, max = 100, message="include restaurant name")
  private String restaurantName;

  @NotNull
  @Min(1)
  @Max(5)
  private Integer rating;

  private String notes;


  public Burger() {
  }

  public Burger(String name, String restaurantName, int rating, String notes) {
    this.name = name;
    this.restaurantName = restaurantName;
    this.rating = rating;
    this.notes = notes;

  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRestaurantName() {
    return this.restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public Integer getRating() {
    return this.rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getNotes() {
    return this.notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }



}
