package com.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * webSocket启动类
 * @author LiChangyuan
 * @Date 2019-07-12 15:45
 */
@EnableScheduling
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebSocketApp {
    public static void main(String[] args){
        SpringApplication.run(WebSocketApp.class, args);
    }

}