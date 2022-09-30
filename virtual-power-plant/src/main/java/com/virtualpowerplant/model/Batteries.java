package com.virtualpowerplant.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Batteries{
    @Id
    private String id;
    @NotBlank(message = "Name of batteries is required")
    private String name;
    @NotBlank(message = "Postcode is required")
    private int postcode;
    @NotBlank(message = "capacity is required")
    private double capacity;
}
