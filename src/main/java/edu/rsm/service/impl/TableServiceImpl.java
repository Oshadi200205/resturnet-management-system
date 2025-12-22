package edu.rsm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.rsm.dto.Table;
import edu.rsm.entity.TableEntity;
import edu.rsm.repository.TableRepository;
import edu.rsm.service.TableService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {

    private  final TableRepository tableRepository;

    private final ObjectMapper mapper;

    @Override
    public void add(Table table) {
        tableRepository.save(toEntity(table));
    }

    @Override
    public List<Table> getAll() {
        return tableRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Table getById(String tableId) {
        return toDto(getEntity(tableId));
    }

    @Override
    public void deleteById(String tableId) {
        tableRepository.deleteById(tableId);
    }

    @Override
    public void updateById(String tableId, Table table) {
        getEntity(tableId);
        TableEntity toSave = toEntity(table);
        toSave.setId(tableId);
        tableRepository.save(toSave);
    }

    private TableEntity getEntity(String id){
        return tableRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Table not Found"));
    }

    private TableEntity toEntity(Table dto){
        return mapper.convertValue(dto,TableEntity.class);
    }

    private Table toDto(TableEntity entity){
        return mapper.convertValue(entity,Table.class);
    }

}
