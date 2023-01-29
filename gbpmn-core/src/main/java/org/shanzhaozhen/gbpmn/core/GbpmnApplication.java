package org.shanzhaozhen.gbpmn.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("org.shanzhaozhen.uaa.mapper")
public class GbpmnApplication {

    static void main(String[] args) {
        SpringApplication.run(GbpmnApplication.class, args);
    }

}
