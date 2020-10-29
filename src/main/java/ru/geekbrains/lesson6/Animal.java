package ru.geekbrains.lesson6;

import java.util.Random;

public abstract class Animal {
    protected Random random = new Random();

    public abstract boolean run(int length);

    public abstract boolean swim(int length);

    public abstract boolean jump(double height);
}
