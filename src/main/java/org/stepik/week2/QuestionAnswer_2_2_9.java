package org.stepik.week2;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_2_2_9 {
    /*
     * Вопрос: Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.
     *
     * Решать можно разными способами:
     * - воспользовавшись одним удобным статическим методом из класса java.lang.Integer;
     * - применив пару трюков из двоичной арифметики;
     * - написав решение "в лоб" с циклом и условными операторами (можете вернуться к этой
     * задаче после просмотра соответствующих уроков).
     *
     * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку
     * ввода-вывода добавит проверяющая система.
     *
     * Ответ:
     * см.ниже
     */
    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        if (value == 0) {
            return false;
        }
        else {
            int res = Math.abs(value);
            return (res & (res - 1)) == 0;
        }
        // you implementation here
    }
}
