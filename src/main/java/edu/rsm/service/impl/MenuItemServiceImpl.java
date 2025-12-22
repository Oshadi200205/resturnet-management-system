package edu.rsm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.rsm.dto.MenuItem;
import edu.rsm.entity.MenuItemEntity;
import edu.rsm.repository.MenuItemRepository;
import edu.rsm.service.MenuItemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    private final ObjectMapper mapper;

    @Override
    public void save(MenuItem menuItem) {
        menuItemRepository.save(mapper.convertValue(menuItem,MenuItemEntity.class));
    }

    @Override
    public List<MenuItem> getAll() {
        return menuItemRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MenuItem getById(String id) {
        return toDto(getEntity(id));
    }

    @Override
    public void updateById(String menuItemId, MenuItem menuItem) {
        getEntity(menuItemId);
        MenuItemEntity tosave = toEntity(menuItem);
        tosave.setId(menuItemId);
        menuItemRepository.save(tosave);
    }

    @Override
    public void deletById(String id) {
        menuItemRepository.deleteById(id);
    }

    private MenuItemEntity getEntity(String id){
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MenuItem Is Not Available"));
    }

    private MenuItemEntity toEntity(MenuItem dto){
        return mapper.convertValue(dto,MenuItemEntity.class);
    }

    private MenuItem toDto(MenuItemEntity entity){
        return mapper.convertValue(entity,MenuItem.class);
    }
}
