package com.virtualpowerplant.model.dto.mapper;

import com.virtualpowerplant.model.Batteries;
import com.virtualpowerplant.model.dto.BatteriesDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface BatteriesMapper {

    BatteriesDto toDto(Batteries batteries);

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    Batteries toEntity(BatteriesDto batteriesDto);
}
