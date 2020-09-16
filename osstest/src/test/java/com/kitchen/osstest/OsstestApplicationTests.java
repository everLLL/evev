package com.kitchen.osstest;

import com.kitchen.osstest.utils.AliyunOssUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class OsstestApplicationTests {

    @Autowired
    private AliyunOssUtil aliyunOssUtil;
    @Test
    void contextLoads() throws IOException {
        //https://yuans-video.oss-cn-beijing.aliyuncs.com/mothBaby/20200720/106cef3aacec421e8f01a9f1c4c3023f.jpg
        aliyunOssUtil.downLoad("mothBaby/20200720/106cef3aacec421e8f01a9f1c4c3023f.jpg");
    }

}
