package com.virtualpowerplant.service.impl;

import com.virtualpowerplant.model.dto.response.EntityCreatedResponse;
import com.virtualpowerplant.exceptionhandlers.exceptions.EntityNotFoundException;
import com.virtualpowerplant.model.Batteries;
import com.virtualpowerplant.model.dto.BatteriesDto;
import com.virtualpowerplant.model.dto.CapacityDto;
import com.virtualpowerplant.model.dto.mapper.BatteriesMapper;
import com.virtualpowerplant.repository.BatteriesRepository;
import com.virtualpowerplant.service.IBatteriesService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteriesService implements IBatteriesService {

    private BatteriesRepository batteriesRepository;

    private BatteriesMapper batteriesMapper;

    public BatteriesService(BatteriesRepository batteriesRepository, BatteriesMapper batteriesMapper) {
        this.batteriesRepository = batteriesRepository;
        this.batteriesMapper = batteriesMapper;
    }

    @Override
    public EntityCreatedResponse create(BatteriesDto batteriesDto) {
        Batteries batteries = batteriesRepository.save(batteriesMapper.toEntity(batteriesDto));
        return new EntityCreatedResponse("Battery created successfully", HttpStatus.CREATED, batteries.getId());
    }

    @Override
    public Batteries findBatteriesById(String id) {
        return batteriesRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Batteries with id " + id + " not found"));
    }

    @Override
    public CapacityDto getAllBatteries(int postcode) {
        List<Batteries> batteriesList = batteriesRepository.findAll();
        List<Batteries> batteriesListStream = batteriesList.stream()
                .sorted(Comparator.comparing((Batteries b) -> b.getName()).thenComparing(b -> b.getPostcode()))
                .filter(p -> p.getPostcode() <= postcode)
                .collect(Collectors.toList());

        if(batteriesListStream.isEmpty()) throw new EntityNotFoundException("Provide postcode range list not found!");

        double average = batteriesListStream.stream().mapToDouble(Batteries::getCapacity).average().getAsDouble();
        int total = (int) batteriesListStream.stream().count();

        CapacityDto capacityDto = new CapacityDto();
        capacityDto.setAverage(average);
        capacityDto.setTotal(total);
        capacityDto.setBatterieslist(batteriesListStream);
        return capacityDto;
    }
}
