package com.endava.calculator.basic;

public interface BasicOperations {

    public abstract int add(int... numbers);
    public abstract long add(long... numbers);
    public abstract double add(double... numbers);

    public abstract int subtract(int... numbers);
    public abstract long subtract(long... numbers);
    public abstract double subtract(double... numbers);

    public abstract long multiply(int... numbers);
    public abstract long multiply(long... numbers);
    public abstract double multiply(double... numbers);

    public abstract double divide(int... numbers);
    public abstract double divide(long... numbers);
    public abstract double divide(double... numbers);
}
