package edu.rsm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.rsm.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private String id;

    @Column(name = "order_status")
    private OrderStatus status;

    @Column(name = "date_and_time")
    private ZonedDateTime createAt;

    @Column(name = "update_date_and_time")
    private ZonedDateTime updateAt;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    @JsonManagedReference("orderEntity-orderItemList")
    private List<OrderItemEntity> orderItemList;

    @ManyToOne
    @JoinColumn(name = "customer_session_id")
    @JsonBackReference
    private CustomerSessionEntity customerSession;

}
