package com.shahinkhalajestani.KilidTask.repos;

import com.shahinkhalajestani.KilidTask.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {
}