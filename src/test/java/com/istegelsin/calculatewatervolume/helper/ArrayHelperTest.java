package com.istegelsin.calculatewatervolume.helper;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayHelperTest {

    @Test
    public void it_should_get_index_of_max_element_given_array() {
        // When
        int index = ArrayHelper.getIndexOfMaxElement(Arrays.asList(8, 7, 6, 5, 1, 9, 3, 4));

        // Then
        assertThat(index).isEqualTo(5);
    }

    @Test
    public void it_should_get_index_of_second_element_given_array() {
        // When
        int index = ArrayHelper.getIndexOfSecondElement(Arrays.asList(8, 7, 6, 5, 1, 9, 3, 4));

        // Then
        assertThat(index).isEqualTo(0);
    }

    @Test
    public void it_should_crop_array_given_indexes() {
        // When
        List<Integer> array = ArrayHelper.cropArrayByMaxAndSecondIndex(Arrays.asList(8, 7, 6, 5, 1, 9, 3, 4), 5, 0);

        // Then
        assertThat(array).containsExactly(8, 3, 4);
    }
}