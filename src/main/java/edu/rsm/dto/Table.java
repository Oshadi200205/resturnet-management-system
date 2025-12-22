package edu.rsm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table {

    private String id;
    private int number;
    private int seatCount;
    private boolean isAvailable;
}
