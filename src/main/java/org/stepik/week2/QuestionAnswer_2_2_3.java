package org.stepik.week2;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_2_2_3 {
    /*
     * Вопрос: Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после
     * символа "\" (обратный слэш) на расстоянии a.
     *
     * В качестве примера написано заведомо неправильное выражение. Исправьте его.
     *
     *Ответ:
     * см.ниже
     */
    public static char charExpression(int a) {
        int s = '\\';
        int sum = s + a;
        return (char) sum;
    }
}
