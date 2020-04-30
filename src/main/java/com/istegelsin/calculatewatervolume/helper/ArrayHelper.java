package com.istegelsin.calculatewatervolume.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArrayHelper {

    public static Integer getMaxElement(List<Integer> integerList) {
        return integerList.stream()
                .max(Integer::compare)
                .orElseThrow(NoSuchElementException::new);
    }

    public static int getIndexOfMaxElement(List<Integer> integerList) {
        return IntStream.range(0, integerList.size())
                .boxed()
                .max(Comparator.comparing(integerList::get))
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Integer> cropArrayByIndex(List<Integer> integerList, int index) {
        if (index >= integerList.size()) {
            return Collections.emptyList();
        }
        return integerList.subList(index + 1, integerList.size());
    }
}
