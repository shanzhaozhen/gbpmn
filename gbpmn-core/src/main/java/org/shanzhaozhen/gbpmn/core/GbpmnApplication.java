package org.shanzhaozhen.gbpmn.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.shanzhaozhen.gbpmn.core.mapper")
public class GbpmnApplication {

    public static void main(String[] args) {
        SpringApplication.run(GbpmnApplication.class, args);
    }

}
