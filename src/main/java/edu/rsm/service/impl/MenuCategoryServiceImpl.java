package edu.rsm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.rsm.dto.MenuCategory;
import edu.rsm.entity.MenuCategoryEntity;
import edu.rsm.repository.MenuCategoryRepository;
import edu.rsm.service.MenuCategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuCategoryServiceImpl implements MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;

    private final ObjectMapper mapper;

    @Override
    public void save(MenuCategory menuCategory) {
        menuCategoryRepository.save(mapper.convertValue(menuCategory, MenuCategoryEntity.class));
    }

    @Override
    public List<MenuCategory> getAll() {
        return menuCategoryRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public MenuCategory getById(String menuCategoryId) {
        return toDto(getEntity(menuCategoryId));
    }

    @Override
    public void deleteById(String menuCategoryId) {
        menuCategoryRepository.deleteById(menuCategoryId);
    }

    @Override
    public MenuCategory updateById(String menuCategoryId, MenuCategory menuCategory) {
        getEntity(menuCategoryId);
        MenuCategoryEntity toSave = toEnity(menuCategory);
        toSave.setId(menuCategoryId);
        return toDto(menuCategoryRepository.save(toSave));
    }

    private MenuCategoryEntity getEntity(String id){
        return menuCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MenuCategory Not Available"));
    }

    private MenuCategory toDto(MenuCategoryEntity entity){
        return mapper.convertValue(entity, MenuCategory.class);
    }

    private MenuCategoryEntity toEnity(MenuCategory dto){
        return mapper.convertValue(dto, MenuCategoryEntity.class);
    }
}
