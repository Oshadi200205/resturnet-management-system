package edu.rsm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.rsm.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "staff")
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "members_name")
    private String name;

    private Role role;

    @ManyToOne
    @JoinColumn(name = "fk_restaurant_id")
    @JsonBackReference("staffList-restaurant1")
    private RestaurantEntity restaurant1;
}
