package com.istegelsin.calculatewatervolume.service;

import com.istegelsin.calculatewatervolume.helper.ArrayHelper;
import com.istegelsin.calculatewatervolume.model.WaterVolumeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

@Service
public class WaterVolumeService {

    public WaterVolumeResponse getWaterVolumeResponse(List<Integer> barList) {

        Objects.requireNonNull(barList, "barList must not be null");
        int totalWaterVolume = 0;
        if (!barList.isEmpty()) {
            totalWaterVolume = calculate(barList, barList.get(0));
        }
        return WaterVolumeResponse.builder()
                .totalWaterVolume(totalWaterVolume)
                .build();
    }

    private int calculate(List<Integer> list, Integer maxValue) {
        int sum = 0;
        if (list.isEmpty()) {
            return sum;
        }
        final Integer maxElement = ArrayHelper.getMaxElement(list);
        final int indexOfMaxElement = ArrayHelper.getIndexOfMaxElement(list);
        final int pivotElement = Math.min(maxElement, maxValue);
        sum = IntStream.range(0, indexOfMaxElement).map(i -> pivotElement - list.get(i)).sum();
        return sum + calculate(ArrayHelper.cropArrayByIndex(list, indexOfMaxElement), maxElement);
    }
}
