package org.stepik.week6;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_6_4_11 {
    /*
     * Вопрос: Напишите метод, возвращающий стрим псевдослучайных целых чисел.
     * Алгоритм генерации чисел следующий:
     *
     *     1)Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
     *     2)Первый элемент последовательности устанавливается равным этому числу.
     *     3)Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn2) R_{n+1}=\mathrm{mid}(R_{n}^2)
     *      Rn+1​=mid(Rn2​), где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа.
     *      Например, mid(123456)=345 \mathrm{mid}(123456) = 345 mid(123456)=345.
     *
     * Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)
     *
     * Пример
     *
     * pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:
     *
     * 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)
     *
     *
     * Ответ: см.ниже
     *
     */

    public static IntStream pseudoRandomStream(int seed) {
        IntSupplier generator = new IntSupplier() {
            int current = 0;

            int mid(int idx) {
                if (idx == 0) return seed;
                int m = mid(idx - 1); m *= m;

                int result = 0, cnt = 0, r;
                while (m > 0) {
                    r = m % 10; cnt++;
                    if (cnt >= 2 && cnt <= 4) result += r * Math.pow(10, cnt - 2);
                    m /= 10;
                }

                return result;
            }

            public int getAsInt() {
                return mid(current++);
            }
        };

        IntStream natural = IntStream.generate(generator);

        return natural;
        // your implementation here
    }
}
