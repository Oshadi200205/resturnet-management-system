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
@Table(name = "MenuItem")
public class MenuItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "item_id")
    private String id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "available")
    private boolean isAvailable;

    private Double price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_menuCategory_id")
    @JsonBackReference
    private MenuCategoryEntity menuCategory;

    @OneToMany(mappedBy = "menuItemEntity",cascade = CascadeType.ALL)
    @JsonManagedReference("menuItemEntity-orderItemList")
    private List<OrderItemEntity> orderItemList;

}
