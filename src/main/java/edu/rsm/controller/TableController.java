package edu.rsm.controller;

import edu.rsm.dto.Table;
import edu.rsm.service.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/table")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    @PostMapping("/add")
    public void add(@RequestBody Table table){
        tableService.add(table);
    }

    @GetMapping("/getAll")
    public List<Table> getAll(){
        return tableService.getAll();
    }

    @GetMapping("/{id}")
    public Table getById(@PathVariable("id")String tableId){
        return tableService.getById(tableId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String tableId){
        tableService.deleteById(tableId);
    }

    @PutMapping("/{id}")
    public void updatebyId(@PathVariable("id") String tableId, @RequestBody Table table){
        tableService.updateById(tableId,table);
    }
}
