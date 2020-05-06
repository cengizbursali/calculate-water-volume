package com.istegelsin.calculatewatervolume.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArrayHelper {

    public static int getIndexOfMaxElement(List<Integer> integerList) {
        return IntStream.range(0, integerList.size())
                .boxed()
                .max(Comparator.comparing(integerList::get))
                .orElseThrow(NoSuchElementException::new);
    }

    public static int getIndexOfSecondElement(List<Integer> list) {

        Integer indexOfMaxElement = IntStream.range(0, list.size())
                .boxed()
                .max(Comparator.comparing(list::get))
                .orElseThrow(NoSuchElementException::new);

        return IntStream.range(0, list.size())
                .filter(i -> !Objects.equals(i, indexOfMaxElement))
                .boxed()
                .max(Comparator.comparing(list::get))
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Integer> cropArrayByMaxAndSecondIndex(List<Integer> list, int indexOfMaxElement, int indexOfSecondElement) {
        int left;
        int right;
        if (indexOfMaxElement > indexOfSecondElement) {
            left = indexOfSecondElement + 1;
            right = indexOfMaxElement;
        } else {
            left = indexOfMaxElement;
            right = indexOfSecondElement - 1;
        }

        return IntStream.range(0, list.size())
                .filter(i -> i < left || i > right)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }

}
