package edu.rsm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.rsm.dto.Staff;
import edu.rsm.entity.StaffEntity;
import edu.rsm.repository.StaffRepository;
import edu.rsm.service.StaffService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    private final ObjectMapper mapper;

    @Override
    public void add(Staff staff) {
        staffRepository.save(mapper.convertValue(staff, StaffEntity.class));
    }

    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Staff getById(int staffId) {
        return toDto(getEntity(staffId));
    }

    @Override
    public void deleteById(int staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public Staff updateById(int staffId, Staff staff) {
        getEntity(staffId);
        StaffEntity toSave = toEntity(staff);
        toSave.setId(staffId);
        return toDto(staffRepository.save(toSave));
    }

    private StaffEntity getEntity(int id){
       return staffRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("staff Id Is Not found"));
    }

    private StaffEntity toEntity(Staff dto){
        return mapper.convertValue(dto, StaffEntity.class);
    }

    private Staff toDto(StaffEntity entity){
        return mapper.convertValue(entity,Staff.class);
    }
}
