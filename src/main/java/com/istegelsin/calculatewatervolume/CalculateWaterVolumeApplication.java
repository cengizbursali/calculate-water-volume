package com.istegelsin.calculatewatervolume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class CalculateWaterVolumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculateWaterVolumeApplication.class, args);
    }

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Turkey"));
    }
}
