package edu.rsm.repository;

import edu.rsm.entity.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<TableEntity,String> {
}
