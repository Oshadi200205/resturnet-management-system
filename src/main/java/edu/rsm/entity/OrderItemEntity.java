package edu.rsm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private double quantity;

    private BigDecimal price_at_time;

    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    @JsonBackReference
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "fk_menuItem_id")
    @JsonBackReference
    private MenuItemEntity menuItemEntity;

}
