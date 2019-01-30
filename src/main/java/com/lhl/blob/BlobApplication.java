package com.lhl.blob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lhl.blob.mapper")
@SpringBootApplication
public class BlobApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlobApplication.class, args);
    }

}

