package edu.rsm.controller;

import edu.rsm.dto.MenuCategory;
import edu.rsm.service.MenuCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/menucategory")
@RequiredArgsConstructor
public class MenuCategoryController {

    private final MenuCategoryService menuCategoryService;

    @PostMapping("/save")
    public void save(@RequestBody MenuCategory menuCategory){
        menuCategoryService.save(menuCategory);
    }

    @GetMapping("/getAll")
    public List<MenuCategory> getAll(){
        return menuCategoryService.getAll();
    }

    @GetMapping("/{id}")
    public MenuCategory getById(@PathVariable("id") String menuCategoryId){
        return menuCategoryService.getById(menuCategoryId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String menuCategoryId){
        menuCategoryService.deleteById(menuCategoryId);
    }

    @PutMapping("/{id}")
    public MenuCategory updateById(@PathVariable("id") String menuCategoryId, @RequestBody MenuCategory menuCategory){
        return menuCategoryService.updateById(menuCategoryId , menuCategory);
    }
}
