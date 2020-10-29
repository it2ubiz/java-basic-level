package ru.geekbrains.lesson6;


public class Cat extends Animal {
    @Override
    public boolean run(int length) {
        return length < random.nextInt(400);
    }

    @Override
    public boolean swim(int length) {
        return false;
    }

    @Override
    public boolean jump(double height) {
        return height < random.nextInt(4);
    }
}
