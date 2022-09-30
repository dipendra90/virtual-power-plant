package com.virtualpowerplant.controller;

import com.virtualpowerplant.model.dto.response.EntityCreatedResponse;
import com.virtualpowerplant.model.dto.BatteriesDto;
import com.virtualpowerplant.service.impl.BatteriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("batteries")
public class BatteriesController {

    private BatteriesService batteriesService;

    public BatteriesController(BatteriesService batteriesService) {
        this.batteriesService = batteriesService;
    }

    @PostMapping
    public ResponseEntity<EntityCreatedResponse> saveStep(@Valid @RequestBody BatteriesDto batteriesDto) {
        EntityCreatedResponse response = batteriesService.create(batteriesDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping
    public ResponseEntity<?> getAllFormTemplate(
            @RequestParam(required = true) int postcode) {
        return new ResponseEntity<>(batteriesService.getAllBatteries(postcode), HttpStatus.OK);
    }
}
