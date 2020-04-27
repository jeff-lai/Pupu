package com.lai.pupu;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.lai.pupu.dao")
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableSwagger2
public class PupuApplication {



    public static void main(String[] args) {
        SpringApplication.run(PupuApplication.class, args);
    }

}
