package com.virtualpowerplant.service;

import com.virtualpowerplant.model.dto.response.EntityCreatedResponse;
import com.virtualpowerplant.model.Batteries;
import com.virtualpowerplant.model.dto.BatteriesDto;
import com.virtualpowerplant.model.dto.CapacityDto;

public interface IBatteriesService {

    EntityCreatedResponse create(BatteriesDto batteriesDto);

    Batteries findBatteriesById(String id);

    CapacityDto getAllBatteries(int postcode);


}
