package com.shahinkhalajestani.KilidTask.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sh.khalajestanii
 * @project KilidTask
 * @since 11/27/2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDto {
    private Long id;
    private String name;
    private String color;
    private Double price;
    private Set<Driver> drivers = new HashSet<>();
}
