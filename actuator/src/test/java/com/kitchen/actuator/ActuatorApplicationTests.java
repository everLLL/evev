package com.kitchen.actuator;

import com.kitchen.actuator.dingding.RobotHelperUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class ActuatorApplicationTests {

    @Test
    void contextLoads() {
        ArrayList<String> phonelist = new ArrayList<>();
        phonelist.add("18367822137");
        RobotHelperUtil.sendMessageByText("测试",phonelist,false);
    }

}
