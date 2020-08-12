package com.kitchen.mapstruct;

import com.kitchen.mapstruct.convert.UserConvert;
import com.kitchen.mapstruct.entity.Person;
import com.kitchen.mapstruct.entity.UserDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapstructApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapstructApplication.class, args);
    }

}
