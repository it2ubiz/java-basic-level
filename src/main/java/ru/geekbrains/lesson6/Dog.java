package ru.geekbrains.lesson6;

/**
 * Class Dog
 */
public class Dog extends Animal {
    protected Dog(int runLimit, int swimLimit, float jumpLimit) {
        super(runLimit, swimLimit, jumpLimit);
    }

    @Override
    public boolean run(int length) {
        return length < runLimit;
    }

    @Override
    public boolean swim(int length) {
        return length < swimLimit;
    }

    @Override
    public boolean jump(double height) {
        return height < jumpLimit;
    }
}
