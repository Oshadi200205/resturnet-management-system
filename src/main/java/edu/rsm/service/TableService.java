package edu.rsm.service;

import edu.rsm.dto.Table;

import java.util.List;

public interface TableService {
    void add(Table table);

    List<Table> getAll();

    Table getById(String tableId);

    void deleteById(String tableId);

    void updateById(String tableId, Table table);
}
