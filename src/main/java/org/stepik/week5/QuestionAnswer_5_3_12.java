package org.stepik.week5;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_5_3_12 {
    /*
     * Вопрос: еализуйте метод, который зачитает данные из InputStream и
     * преобразует их в строку, используя заданную кодировку.
     *
     * Пример
     *
     * InputStream последовательно возвращает четыре байта: 48 49 50 51.
     *
     * Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
     *
     *
     * Ответ: см.ниже
     *
     */
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // your implementation here
        String retval;
        Reader reader = new InputStreamReader(inputStream, charset);
        StringWriter r = new StringWriter();
        int b;
        while ((b = reader.read()) != -1) {
            r.write(b);
        }
        retval = r.toString();
        return retval;
    }
}
