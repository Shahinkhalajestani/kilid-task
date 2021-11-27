package com.shahinkhalajestani.KilidTask.repos;

import com.shahinkhalajestani.KilidTask.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long>, JpaSpecificationExecutor<Driver> {
    List<Driver> findAllByNameContains(String name);
}