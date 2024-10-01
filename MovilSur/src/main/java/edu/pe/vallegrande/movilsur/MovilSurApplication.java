package edu.pe.vallegrande.movilsur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MovilSurApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovilSurApplication.class, args);
    }

}
