package ru.geekbrains.lesson6;

/**
 * Class Animal
 */
public class Cat extends Animal {
    protected Cat(int runLimit, float jumpLimit) {
        super(runLimit, 0, jumpLimit);
    }

    @Override
    public boolean run(int length) {
        return length < runLimit;
    }

    @Override
    public boolean swim(int length) {
        return false;
    }

    @Override
    public boolean jump(double height) {
        return height < jumpLimit;
    }
}
