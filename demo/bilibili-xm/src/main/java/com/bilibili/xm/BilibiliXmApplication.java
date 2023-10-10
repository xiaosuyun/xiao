package com.bilibili.xm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bilibili.xm.mapper")
public class BilibiliXmApplication {
    public static void main(String[] args) {
        SpringApplication.run(BilibiliXmApplication.class, args);
    }
}
