package edu.rsm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Tables")
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "table_id")
    private String id;

    @Column(name = "table_number")
    private int number;

    @Column(name = "seat_count")
    private int seatCount;

    @Column(name = "available")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "fk_restaurant_id")
    @JsonBackReference
    private RestaurantEntity restaurant;
}
