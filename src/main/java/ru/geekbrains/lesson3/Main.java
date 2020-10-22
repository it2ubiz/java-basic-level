package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("1 - guessNumber / 2 - guessFruit / 3 - Exit: ");
            switch (scanner.nextInt()) {
                case 1:
                    /* 1. Написать программу, которая загадывает случайное число от 0 до 9,
                    и пользователю дается 3 попытки угадать это число.
                    При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
                    После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет). */
                    guessNumber();
                    break;
                case 2:
                    /* 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana",
                    "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                    melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                    "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
                    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
                    сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
                    Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
                    apple – загаданное apricot - ответ игрока ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
                    Для сравнения двух слов посимвольно, можно пользоваться: String str = "apple";
                    str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
                    Играем до тех пор, пока игрок не отгадает слово Используем только маленькие буквы */
                    guessFruit();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    public static void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        do {
            System.out.println("Guess the number from 0 to 9");
            int hiddenNumber = random.nextInt(9);
            for (int i = 0; i < 3; i++) {
                System.out.print("Insert the number: ");
                int userInput = scanner.nextInt();
                if (userInput == hiddenNumber) {
                    System.out.println("You win");
                    break;
                }
                System.out.println(userInput > hiddenNumber ? "Your number is greater than expected" : "Your number is less than expected");
            }
            System.out.print("Do you want to repeat the game again? 1 - yes / 0 - no: ");
        } while (scanner.nextInt() == 1);
    }

    public static void guessFruit() {
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Press enter to exit");
        String hiddenFruit = words[random.nextInt(words.length)];
        do {
            System.out.print("Enter the hidden fruit: ");
            String userInput = scanner.nextLine();
            if (userInput.equals("")) break;
            else if (userInput.equals(hiddenFruit)) {
                System.out.println("You win");
                hiddenFruit = words[random.nextInt(words.length)];
                continue;
            }
            char[] tempBuffer = new char[hiddenFruit.length()];
            for (int i = 0; i < hiddenFruit.length(); i++) {
                if (i >= userInput.length()) break;
                tempBuffer[i] = hiddenFruit.charAt(i) != userInput.charAt(i) ? '#' : userInput.charAt(i);
            }
            System.out.println(String.valueOf(tempBuffer) + "###############");
        } while (true);
    }
}
