package com.istegelsin.calculatewatervolume.helper;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayHelperTest {

    @Test
    public void it_should_get_max_element_in_array() {
        // When
        Integer max = ArrayHelper.getMaxElement(Arrays.asList(1, 34, 67, 51, 51, 67, 22));

        // Then
        assertThat(max).isEqualTo(67);
    }

    @Test
    public void it_should_get_index_of_max_element_in_array() {
        // When
        Integer max = ArrayHelper.getIndexOfMaxElement(Arrays.asList(11, 34, 22));

        // Then
        assertThat(max).isEqualTo(1);
    }

    @Test
    public void it_should_crop_array_by_index() {
        // When
        List<Integer> result = ArrayHelper.cropArrayByIndex(Arrays.asList(3, 4, 6, 7, 9, 11), 2);

        // Then
        assertThat(result).containsExactly(7, 9, 11);
    }
}