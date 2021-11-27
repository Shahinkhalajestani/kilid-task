package com.shahinkhalajestani.KilidTask.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shahinkhalajestani.KilidTask.domain.Car;
import com.shahinkhalajestani.KilidTask.domain.Driver;
import com.shahinkhalajestani.KilidTask.domain.DriverDto;
import com.shahinkhalajestani.KilidTask.repos.CarRepository;
import com.shahinkhalajestani.KilidTask.repos.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sh.khalajestanii
 * @project KilidTask
 * @since 11/27/2021
 */
@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Override
    //didnt use transactional annotation to avoid auto save on divers
    public List<DriverDto> getDriversByNameAndDontHaveCars(String driverName, List<String> carsName) {
        List<Driver> drivers = getDriversByName(driverName);
        drivers.forEach(driver -> {
            Set<Car> cars = driver.getCars();
            cars = cars.stream().filter(car -> carsName.stream().noneMatch(s -> s.equalsIgnoreCase(car.getName())))
                    .collect(Collectors.toSet());
            driver.setCars(cars);
        });
        return mapToDriverDtos(drivers);
    }

    private List<DriverDto> mapToDriverDtos(List<Driver> drivers) {
        return drivers.stream().map(driver -> DriverDto.builder().id(driver.getId())
                .age(driver.getAge())
                .name(driver.getName())
                .salary(driver.getSalary())
                .cars(driver.getCars()).build()).collect(Collectors.toList());
    }

    private List<Driver> getDriversByName(String driverName) {
        return driverRepository.findAllByNameContains(driverName);
    }

    @Override
    //didnt use transactional annotation to avoid auto save on divers
    public List<DriverDto> getDriversByNameAndDontHaveCarsWithColors(String driverName, List<String> colors) {
        List<Driver> drivers = getDriversByName(driverName);
        drivers.forEach(driver -> {
            Set<Car> cars = driver.getCars();
            cars = cars.stream().filter(car -> colors.stream().noneMatch(s -> s.equalsIgnoreCase(car.getColor())))
                    .collect(Collectors.toSet());
            driver.setCars(cars);
        });
        return mapToDriverDtos(drivers);
    }
}
