package org.stepik.week6;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_6_4_13 {
    /*
     * Вопрос: Напишите программу, читающую из System.in текст в кодировке UTF-8,
     * подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее
     * часто встречающихся слов.
     *
     * Словом будем считать любую непрерывную последовательность символов, состоящую
     * только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов:
     * "Мама", "мыла", "раму", "33" и "раза".
     *
     * Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" —
     * это одно и то же слово. Выводите слова в нижнем регистре.
     *
     * Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
     *
     * Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя
     * однозначно упорядочить только по частоте, то дополнительно упорядочите слова
     * с одинаковой частотой в лексикографическом порядке.
     *
     * Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.

     *
     *
     * Ответ: см. ниже, с 30 по 58 строку без //
     *
     */

//import java.io.IOException;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//
//    public class Main {
//        public static void main(String[] args) throws IOException {
////        System.out.println("6.4 Stream API – Шаг 13");
//            //Сделать Stream из System.in
//            Scanner scanner = new Scanner(System.in, "UTF-8")
//                    .useDelimiter("[^\\p{L}\\p{Digit}]+");
//
//            // Сложить в ХЭШ сразу с подсчетом вхождений
//            HashMap<String, Integer> hashMap = new HashMap<>();
//            scanner.forEachRemaining(n ->
//                    hashMap.put(n.toLowerCase(), hashMap.get(n.toLowerCase()) == null ? 1 : hashMap.get(n.toLowerCase()) + 1));
//
//            // Сортируем, ограничиваем кол-во, берем ключ и выводим
//            hashMap.entrySet().stream()
//                    .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
//                            .reversed()  // Обратная сортировка по количеству
//                            .thenComparing(Map.Entry::getKey))  // потом прямая по словам
//                    .map(Map.Entry::getKey)
//                    .limit(10)
//                    .forEach(System.out::println);
//        }
//    }
}
