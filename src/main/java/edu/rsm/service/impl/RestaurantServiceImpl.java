package edu.rsm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.rsm.dto.Restaurant;
import edu.rsm.entity.RestaurantEntity;
import edu.rsm.repository.RestaurantRepository;
import edu.rsm.service.RestauranetService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestauranetService {

    private final RestaurantRepository restaurantRepository;

    private final ObjectMapper mapper;

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(mapper.convertValue(restaurant,RestaurantEntity.class));
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantEntity -> mapper.convertValue(restaurantEntity,Restaurant.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateById(String restaurantID, Restaurant restaurant) {
        getEntity(restaurantID);
        RestaurantEntity toSave = toEntity(restaurant);
        toSave.setId(restaurantID);
        restaurantRepository.save(toSave);

    }

    @Override
    public void deletById(String id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant getById(String id) {
        return toDto(getEntity(id));
    }

    private RestaurantEntity getEntity(String restaurantId){
        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
    }

    private RestaurantEntity toEntity(Restaurant dto){
        return mapper.convertValue(dto,RestaurantEntity.class);
    }

    private Restaurant toDto(RestaurantEntity entity){
        return mapper.convertValue(entity,Restaurant.class);
    }
}

