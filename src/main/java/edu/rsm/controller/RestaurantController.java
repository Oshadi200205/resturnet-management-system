package edu.rsm.controller;

import edu.rsm.dto.Restaurant;
import edu.rsm.service.RestauranetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestauranetService restauranetService;

    @PostMapping("/save")
    public String create(@RequestBody Restaurant restaurant){
        restauranetService.createRestaurant(restaurant);
        return "Create Successful";
    }

    @GetMapping("/getAll")
    public List<Restaurant> getAll(){
        return restauranetService.getAll();
    }

    @GetMapping("/{id}")
    public Restaurant getByID(@PathVariable String id){
        return restauranetService.getById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id")String restaurantID,@RequestBody Restaurant restaurant){
        restauranetService.updateById(restaurantID,restaurant);
        return "Update Successful";
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        restauranetService.deletById(id);
    }
}
