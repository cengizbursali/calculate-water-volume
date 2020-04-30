package com.istegelsin.calculatewatervolume.controller;

import com.istegelsin.calculatewatervolume.model.WaterVolumeResponse;
import com.istegelsin.calculatewatervolume.service.WaterVolumeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = WaterVolumeController.class)
public class WaterVolumeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WaterVolumeService waterVolumeService;

    @Test
    public void it_should_get_water_volume_response_given_params() throws Exception {
        // Given
        WaterVolumeResponse waterVolumeResponse = WaterVolumeResponse.builder().totalWaterVolume(3).build();
        List<Integer> barList = Arrays.asList(8, 2, 5);
        when(waterVolumeService.getWaterVolumeResponse(barList)).thenReturn(waterVolumeResponse);

        // When
        final ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/water-volumes?barList=8,2,5"));

        // Then
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$.totalWaterVolume").value(3));
        verify(waterVolumeService).getWaterVolumeResponse(barList);
    }
}