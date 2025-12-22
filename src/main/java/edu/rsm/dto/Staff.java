package edu.rsm.dto;

import edu.rsm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    private int id;
    private String name;
    private Role role;
}
