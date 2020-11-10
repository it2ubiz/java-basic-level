package org.stepik.week5;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_5_2_8 {
    /*
     * Вопрос: Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
     *
     * Контрольная сумма данных вычисляется по следующему алгоритму:
     *
     *     Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
     *     Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:
     *      Cn+1=rotateLeft(Cn) xor bn+1 C_{n+1}=\mathrm{rotateLeft}(C_n)\ \mathrm{xor}\ b_{n+1} Cn+1​=
     *      rotateLeft(Cn​) xor bn+1​ , где Cn C_n Cn​ — контрольная сумма первых n байт данных, rotateLeft —
     *      циклический сдвиг бит числа на один бит влево (чтобы не изобретать велосипед, используйте
     *      Integer.rotateLeft), bn b_n bn​ — n-ный байт данных.
     *
     * Поскольку метод не открывал данный InputStream, то и закрывать его он не должен.
     * Выброшенное из методов InputStream исключение должно выбрасываться из метода.
     *
     * Пример
     *
     * На вход подан InputStream, последовательно возвращающий три байта: 0x33 0x45 0x01.
     * В качестве контрольной суммы должно быть возвращено число 71.
     *
     * Ответ: см. ниже
     *
     */
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        // your implementation here
        int checkSum = 0;

        int x = inputStream.read();
        while(x != -1) {
            checkSum = Integer.rotateLeft(checkSum, 1) ^ x;
            x = inputStream.read();
        }

        return checkSum;
    }

}
