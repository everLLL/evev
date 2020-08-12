package com.kitchen.mapstruct.convert;

import com.kitchen.mapstruct.entity.Person;
import com.kitchen.mapstruct.entity.UserDTO;
import com.kitchen.mapstruct.entity.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserConvert {
    UserConvert INSTANCES =Mappers.getMapper(UserConvert.class);

    @Mappings({})
    Person convertToperson(UserDTO dto);
    @Mappings({})
    Worker convertToworker(UserDTO dto);
}
