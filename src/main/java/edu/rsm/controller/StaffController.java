package edu.rsm.controller;

import edu.rsm.dto.Staff;
import edu.rsm.repository.StaffRepository;
import edu.rsm.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @PostMapping("/add")
    public void add(@RequestBody Staff staff){
        staffService.add(staff);
    }

    @GetMapping("/getAll")
    public List<Staff> getAll(){
        return staffService.getAll();
    }

    @GetMapping("/{id}")
    public Staff getById(@PathVariable("id") int staffId){
        return staffService.getById(staffId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int staffId){
        staffService.deleteById(staffId);
    }

    @PutMapping("/{id}")
    public Staff updateById(@PathVariable("id") int staffId, @RequestBody Staff staff){
        return staffService.updateById(staffId,staff);
    }
}
