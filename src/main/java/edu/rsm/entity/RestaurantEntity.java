package edu.rsm.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Restaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "restaurant_id")
    private String id;

    @Column(name = "restaurant_name")
    private String name;

    @Column(name = "contact_detail")
    private int phoneNumber;

    @Column(name = "status")
    private boolean isOpen;

    private String location;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MenuCategoryEntity> menuCategoryList;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<StaffEntity> staffList;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TableEntity> tableList;

}
