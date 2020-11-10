package org.stepik.week6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_6_4_12 {
    /*
     * Вопрос: Напишите метод, находящий в стриме минимальный и максимальный
     * элементы в соответствии порядком, заданным Comparator'ом.
     *
     * Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
     *
     * minMaxConsumer.accept(min, max);
     *
     * Если стрим не содержит элементов, то вызовите
     *
     * minMaxConsumer.accept(null, null);
     *
     * Ответ: см.ниже
     */

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
        List<T> arrayList;
        T min = null;
        T max = null;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
        minMaxConsumer.accept(min, max);
    }
}
