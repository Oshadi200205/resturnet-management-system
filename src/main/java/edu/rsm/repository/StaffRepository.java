package edu.rsm.repository;

import edu.rsm.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity,Integer> {
}
