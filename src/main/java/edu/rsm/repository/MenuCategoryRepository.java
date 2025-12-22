package edu.rsm.repository;

import edu.rsm.entity.MenuCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuCategoryRepository extends JpaRepository<MenuCategoryEntity,String> {
}
