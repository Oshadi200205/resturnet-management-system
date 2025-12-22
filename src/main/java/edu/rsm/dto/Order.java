package edu.rsm.dto;

import edu.rsm.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private OrderStatus status;
    private ZonedDateTime createAt;
    private ZonedDateTime updateAt;
}
