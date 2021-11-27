package com.shahinkhalajestani.KilidTask.services;

import com.shahinkhalajestani.KilidTask.domain.DriverDto;

import java.util.List;

/**
 * @author sh.khalajestanii
 * @project KilidTask
 * @since 11/27/2021
 */
public interface DriverService {
    List<DriverDto> getDriversByNameAndDontHaveCars(String driverName ,List<String> carsName);
    List<DriverDto> getDriversByNameAndDontHaveCarsWithColors(String driverName,List<String> colors);

}
