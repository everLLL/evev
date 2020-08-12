package com.kitchen.mapstruct;

import com.kitchen.mapstruct.convert.UserConvert;
import com.kitchen.mapstruct.entity.Person;
import com.kitchen.mapstruct.entity.UserDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapstructApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void mytest(){
        UserDTO dto = new UserDTO(1, "张三", 1, "教师");
//        UserConvert mapper = Mappers.getMapper(UserConvert.class);
        //        Person person = mapper.convertToperson(dto);
        Person person = UserConvert.INSTANCES.convertToperson(dto);
        System.out.println(person);
    }

}
