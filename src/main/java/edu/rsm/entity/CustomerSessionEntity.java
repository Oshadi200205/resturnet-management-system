package edu.rsm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customer_session")
public class CustomerSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "session_id")
    private int id;

    private Instant startedAt;

    private Instant endedAt;

    @ManyToOne
    @JoinColumn(name = "table_id")
    @JsonBackReference
    private TableEntity table;

    @OneToMany(mappedBy = "customerSession",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderEntity> orderList;
}
