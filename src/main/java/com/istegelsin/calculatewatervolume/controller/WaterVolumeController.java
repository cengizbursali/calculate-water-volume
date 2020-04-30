package com.istegelsin.calculatewatervolume.controller;

import com.istegelsin.calculatewatervolume.model.WaterVolumeResponse;
import com.istegelsin.calculatewatervolume.service.WaterVolumeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/water-volumes")
public class WaterVolumeController {

    private final WaterVolumeService waterVolumeService;

    @GetMapping
    public WaterVolumeResponse getWaterVolumeResponse(@RequestParam(name = "barList") List<Integer> barList) {
        log.info("barList from client: {}", barList);
        return waterVolumeService.getWaterVolumeResponse(barList);
    }
}
