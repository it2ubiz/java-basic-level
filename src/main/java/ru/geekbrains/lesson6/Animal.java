package ru.geekbrains.lesson6;

/**
 * Abstract class Animal
 */
public abstract class Animal {
    protected int runLimit;
    protected int swimLimit;
    protected float jumpLimit;

    protected Animal(int runLimit, int swimLimit, float jumpLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
    }

    public abstract boolean run(int length);

    public abstract boolean swim(int length);

    public abstract boolean jump(double height);
}
