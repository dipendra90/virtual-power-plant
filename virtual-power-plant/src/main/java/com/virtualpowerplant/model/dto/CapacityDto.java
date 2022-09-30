package com.virtualpowerplant.model.dto;

import com.virtualpowerplant.model.Batteries;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapacityDto {
    int total;
    double average;
    List<Batteries> batterieslist;
}
