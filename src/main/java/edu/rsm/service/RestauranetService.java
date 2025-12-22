package edu.rsm.service;

import edu.rsm.dto.Restaurant;

import java.util.List;

public interface RestauranetService {
    void createRestaurant(Restaurant restaurant);

    List<Restaurant> getAll();

    void updateById(String restaurantID, Restaurant restaurant);

    void deletById(String id);

    Restaurant getById(String id);
}
