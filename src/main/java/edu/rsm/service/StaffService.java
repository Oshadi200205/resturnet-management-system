package edu.rsm.service;

import edu.rsm.dto.Staff;

import java.util.List;

public interface StaffService {
    void add(Staff staff);

    List<Staff> getAll();

    Staff getById(int staffId);

    void deleteById(int staffId);

    Staff updateById(int staffId, Staff staff);
}
