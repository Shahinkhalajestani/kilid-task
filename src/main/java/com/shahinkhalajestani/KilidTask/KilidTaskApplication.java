package com.shahinkhalajestani.KilidTask;

import com.shahinkhalajestani.KilidTask.domain.Car;
import com.shahinkhalajestani.KilidTask.domain.Driver;
import com.shahinkhalajestani.KilidTask.repos.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class KilidTaskApplication implements CommandLineRunner {

    private final DriverRepository driverRepository;

    public static void main(String[] args) {
        SpringApplication.run(KilidTaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Set<Car> carSet1 = Set.of(Car.builder().name("ford").color("Gray").price(650000d).build(),
                Car.builder().name("lambo").color("Red").price(650000d).build()
                , Car.builder().name("Toyota").color("Gray").price(650000d).build(),
                Car.builder().name("ferrari").color("Black").price(900000d).build());
        Set<Car> carSet2 = Set.of(Car.builder().name("BMW").color("green").price(700000d).build(),
                Car.builder().name("MCLauren").color("blue").price(750000d).build(),
                Car.builder().name("Acura").color("Orange").price(750000d).build(),
                Car.builder().name("MCLauren").color("White").price(750000d).build());
        List<Driver> drivers = List.of(new Driver(null, "shahin", 28L, 65.3d, carSet1),
                new Driver(null, "abbas", 28L, 65.3d, carSet1),
                new Driver(null, "ali", 28L, 65.3d, carSet2),
                new Driver(null, "Ramtin", 28L, 65.3d, carSet2));
        driverRepository.saveAllAndFlush(drivers);
    }
}
