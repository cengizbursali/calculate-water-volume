package com.istegelsin.calculatewatervolume.service;

import com.istegelsin.calculatewatervolume.model.WaterVolumeResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class WaterVolumeServiceTest {

    @InjectMocks
    private WaterVolumeService waterVolumeService;

    @Test
    public void it_should_calculate_water_volume_given_array() {
        // When
        WaterVolumeResponse waterVolumeResponse = waterVolumeService.getWaterVolumeResponse(Arrays.asList(7, 0, 4, 2, 5, 0, 6, 4, 0, 5));

        // Then
        assertThat(waterVolumeResponse.getTotalWaterVolume()).isEqualTo(25);
    }

    @Test
    public void it_should_calculate_water_volume_given_array_is_empty() {
        // When
        WaterVolumeResponse waterVolumeResponse = waterVolumeService.getWaterVolumeResponse(Collections.emptyList());

        // Then
        assertThat(waterVolumeResponse.getTotalWaterVolume()).isZero();
    }
}