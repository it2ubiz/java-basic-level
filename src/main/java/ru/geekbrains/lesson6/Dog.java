package ru.geekbrains.lesson6;

public class Dog extends Animal {
    @Override
    public boolean run(int length) {
        return length < random.nextInt(600);
    }

    @Override
    public boolean swim(int length) {
        return length < random.nextInt(20);
    }

    @Override
    public boolean jump(double height) {
        return height < random.nextDouble();
    }
}
