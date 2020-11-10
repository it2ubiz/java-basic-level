package org.stepik.week6;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_6_1_13 {
    /*
     * Вопрос: Если бы в классе Pair мы захотели написать метод ifPresent,
     * аналогичный одноименному методу класса Optional и принимающий java.util.function.BiConsumer,
     * то как надо было бы объявить такой метод?
     *
     * class Pair<T, U> {
     *     // вариант 1
     *     public void ifPresent(BiConsumer<T, U> consumer) { ... }
     *
     *     // вариант 2
     *     public void ifPresent(BiConsumer<? super T, ? super U> consumer) { ... }
     *
     *     // вариант 3
     *     public void ifPresent(BiConsumer<? extends T, ? extends U> consumer) { ... }
     *
     *     // вариант 4
     *     public void ifPresent(BiConsumer<?, ?> consumer) { ... }
     *
     *     // вариант 5
     *     public <X, Y> void ifPresent(BiConsumer<X, Y> consumer) { ... }
     * }
     *
     *
     * Ответ: вариант 2
     *
     */
}
