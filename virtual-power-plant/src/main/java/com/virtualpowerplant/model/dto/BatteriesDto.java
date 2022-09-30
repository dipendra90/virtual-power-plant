package com.virtualpowerplant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatteriesDto {
    private String id;
    private String name;
    private int postcode;
    private double capacity;
}
