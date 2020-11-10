package org.stepik.week2;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_2_1_12 {
    /*
     * Вопрос: Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
     * Допустимая погрешность – 0.0001 (1E-4)
     *
     * Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.
     *
     * В качестве примера написано заведомо неправильное выражение. Исправьте его.
     *
     *Ответ:
     * см.ниже
     */
    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) < 0.0001;
    }
}
