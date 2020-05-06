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
            totalWaterVolume = calculate(barList);
        }
        return WaterVolumeResponse.builder()
                .totalWaterVolume(totalWaterVolume)
                .build();
    }

    private int calculate(List<Integer> list) {
        int sum = 0;
        if (list.size() < 3) {
            return sum;
        }
        final int indexOfMaxElement = ArrayHelper.getIndexOfMaxElement(list);
        final int indexOfSecondElement = ArrayHelper.getIndexOfSecondElement(list);
        final int pivotElement = list.get(indexOfSecondElement);

        int left = Math.min(indexOfMaxElement, indexOfSecondElement);
        int right = Math.max(indexOfMaxElement, indexOfSecondElement);

        sum = IntStream.range(left + 1, right).map(i -> pivotElement - list.get(i)).sum();

        return sum + calculate(ArrayHelper.cropArrayByMaxAndSecondIndex(list, indexOfMaxElement, indexOfSecondElement));
    }
}
