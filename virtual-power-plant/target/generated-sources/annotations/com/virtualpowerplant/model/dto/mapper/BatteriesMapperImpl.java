package com.virtualpowerplant.model.dto.mapper;

import com.virtualpowerplant.model.Batteries;
import com.virtualpowerplant.model.Batteries.BatteriesBuilder;
import com.virtualpowerplant.model.dto.BatteriesDto;
import com.virtualpowerplant.model.dto.BatteriesDto.BatteriesDtoBuilder;
import java.util.UUID;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-30T10:07:14+0545",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class BatteriesMapperImpl implements BatteriesMapper {

    @Override
    public BatteriesDto toDto(Batteries batteries) {
        if ( batteries == null ) {
            return null;
        }

        BatteriesDtoBuilder batteriesDto = BatteriesDto.builder();

        batteriesDto.id( batteries.getId() );
        batteriesDto.name( batteries.getName() );
        batteriesDto.postcode( batteries.getPostcode() );
        batteriesDto.capacity( batteries.getCapacity() );

        return batteriesDto.build();
    }

    @Override
    public Batteries toEntity(BatteriesDto batteriesDto) {
        if ( batteriesDto == null ) {
            return null;
        }

        BatteriesBuilder batteries = Batteries.builder();

        batteries.name( batteriesDto.getName() );
        batteries.postcode( batteriesDto.getPostcode() );
        batteries.capacity( batteriesDto.getCapacity() );

        batteries.id( UUID.randomUUID().toString() );

        return batteries.build();
    }
}
