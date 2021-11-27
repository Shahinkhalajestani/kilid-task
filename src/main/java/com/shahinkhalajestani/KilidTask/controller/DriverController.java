package com.shahinkhalajestani.KilidTask.controller;

import com.shahinkhalajestani.KilidTask.domain.Car;
import com.shahinkhalajestani.KilidTask.domain.DriverDto;
import com.shahinkhalajestani.KilidTask.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sh.khalajestanii
 * @project KilidTask
 * @since 11/27/2021
 */
@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    record DriverAndCarData(Long driverId,Long driverAge,Double salary,Long carId,
                            Double carPrice,String carColor){}

    @PostMapping("/get-dont-have-cars")
    public ResponseEntity getThatDontHaveCars(@RequestParam(required = true,name = "name") String driverName
    ,@RequestBody String[] carsName){
        List<DriverDto> driversByNameAndDontHaveCars = driverService.getDriversByNameAndDontHaveCars(driverName,
                Arrays.asList(carsName));

        List<DriverAndCarData> driverAndCarData = getDriverAndCarData(driversByNameAndDontHaveCars);
        return new ResponseEntity(driverAndCarData, HttpStatus.OK);
    }

    @PostMapping("/get-dont-have-colors")
    public ResponseEntity getThatCarsDontHaveColors(@RequestParam(required = true,name = "name")String driverName,
                                                    @RequestBody String[] colors){
        List<DriverDto> driversByNameAndDontHaveCarsWithColors = driverService.getDriversByNameAndDontHaveCarsWithColors(driverName,
                Arrays.asList(colors));
        List<DriverAndCarData> driverAndCarData = getDriverAndCarData(driversByNameAndDontHaveCarsWithColors);
        return new ResponseEntity(driverAndCarData,HttpStatus.OK);
    }

    private List<DriverAndCarData> getDriverAndCarData(List<DriverDto> driversByNameAndDontHaveCars) {
        List<DriverAndCarData> driverAndCarData = new ArrayList<>();
        driversByNameAndDontHaveCars.forEach(driverDto -> {
            Set<Car> cars = driverDto.getCars();
            cars.forEach(car -> {
                DriverAndCarData data = new DriverAndCarData(driverDto.getId(), driverDto.getAge(), driverDto.getSalary(),
                        car.getId(), car.getPrice(), car.getColor());
                driverAndCarData.add(data);
            });
        });
        return driverAndCarData;
    }

}
