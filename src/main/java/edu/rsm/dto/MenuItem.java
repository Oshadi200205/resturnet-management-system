package edu.rsm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {

    private String id;
    private String name;
    private boolean isAvailable;
    private Double price;
    private String description;
}
