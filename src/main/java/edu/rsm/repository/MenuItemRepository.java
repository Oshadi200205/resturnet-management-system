package edu.rsm.repository;

import edu.rsm.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItemEntity,String> {
}
