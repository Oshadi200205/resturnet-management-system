package edu.rsm.controller;

import edu.rsm.dto.MenuItem;
import edu.rsm.dto.Restaurant;
import edu.rsm.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/menuitem")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping("/save")
    public String save(@RequestBody MenuItem menuItem){
        menuItemService.save(menuItem);
        return "Create Successful";
    }

    @GetMapping("/getAll")
    public List<MenuItem> getAll(){
        return menuItemService.getAll();
    }

    @GetMapping("/{id}")
    public MenuItem getByID(@PathVariable("id") String id){
        return menuItemService.getById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id")String menuItemId,@RequestBody MenuItem menuItem){
        menuItemService.updateById(menuItemId,menuItem);
        return "Update Successful";
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        menuItemService.deletById(id);
    }
}
