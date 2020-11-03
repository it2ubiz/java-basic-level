package ru.geekbrains.lesson7;

/**
 * Java Core. Basic level. Lesson 7
 *
 * @author Nika Zurbaevi
 * @version dated November 3, 2020
 */
class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Luna", 15), new Cat("Bella", 10), new Cat("Lily", 20)
        };
        Plate plate = new Plate(50, 30);
        System.out.println(plate);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
        plate.add(40);
        System.out.println(plate);
        for (Cat cat : cats) {
            cat.setFullness(false);
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }
}
