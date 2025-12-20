package edu.rsm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Menu")
public class MenuCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "menu_id")
    private String id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "menuCategory",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MenuItemEntity> menuItemEntityList;

    @ManyToOne
    @JoinColumn(name = "fk_restaurant_id")
    @JsonBackReference
    private RestaurantEntity restaurant;

}
