package com.kitchen.seleniumtest;


import okhttp3.Connection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeleniumtestApplication.class, args);
        System.setProperty("webdriver.chrome.driver",
                "/workspace/show/seleniumtest/src/main/resources/chromedriver_win32/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://cx.cnca.cn/CertECloud/result/skipResultList?certNumber=&orgName=%E6%96%B0%E6%97%B6%E6%9C%9F&fromIndex=true");


        //JS打印信息
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("console.log('" + "test" + " ' ) ;");


    }

}
