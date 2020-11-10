package org.stepik.week2;

import java.math.BigInteger;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_2_4_8 {
    /*
     * Вопрос: Реализуйте метод, вычисляющий факториал заданного натурального числа.
     *
     * Факториал N N N вычисляется как 1⋅2⋅...⋅N 1 \cdot 2 \cdot ... \cdot N 1⋅2⋅...⋅N.
     *
     * Поскольку это очень быстро растущая функция, то даже для небольших N N N вместимости
     * типов int и long очень скоро не хватит. Поэтому будем использовать BigInteger.
     *
     * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку
     * ввода-вывода добавит проверяющая система.
     *
     *
     *
     *
     * Ответ: см.ниже
     *
     */
    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        if (BigInteger.valueOf(value).equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= value; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
