package com.endava.calculator.basic;

public class Basic implements BasicOperations{

    protected int defaultDecimals;
    public Basic() {
        defaultDecimals = 10;
    }

    public Basic(int prefDecimals){
        this.defaultDecimals = prefDecimals;
    }



    //    @Override
//    public int add(int[] numbers) {
//        int sum = 0;
//        for (int n : numbers){
//            sum += n;
//        }
//        return sum;
//    }

    // SAU simplificat cu:

    @Override
    public int add(int... numbers) {  // "..." reprezinta in java "numar variabil de argumente"
        int sum = 0;
        for (int n : numbers){
            sum += n;
        }
        return sum;
    }

    @Override
    public int subtract(int... numbers) {
        int diff = numbers[0];
        for (int i = 1; i<numbers.length; i++){
            diff -= numbers[i];
        }
        return diff;
    }

    @Override
    public long multiply(int... numbers) {
        long multiplication = 1;
        for(int n : numbers){
            multiplication *= n;
        }
        return multiplication;
    }

    @Override
    public double divide(int... numbers) {
        double division = numbers[0];
        for (int i = 1; i<numbers.length; i++){
            division /= numbers[i];
        }
        return formatNumber(division);
    }

    @Override
    public long add(long... numbers) {
        long sum = 0;
        for (long n : numbers){
            sum += n;
        }
        return sum;
    }

    @Override
    public double add(double... numbers) {
        double sum = 0;
        for (double n : numbers){
            sum += n;
        }
        return formatNumber(sum);
    }

    @Override
    public long subtract(long... numbers) {
        long diff = numbers[0];
        for (int i = 1; i<numbers.length; i++){
            diff -= numbers[i];
        }
        return diff;
    }

    @Override
    public double subtract(double... numbers) {
        double diff = numbers[0];
        for (int i = 1; i<numbers.length; i++){
            diff -= numbers[i];
        }
        return formatNumber(diff);
    }

    @Override
    public long multiply(long... numbers) {
        long multiplication = 1;
        for(long n : numbers){
            multiplication *= n;
        }
        return multiplication;
    }

    @Override
    public double multiply(double... numbers) {
        double multiplication = 1;
        for(double n : numbers){
            multiplication *= n;
        }
        return formatNumber(multiplication);
    }

    @Override
    public double divide(long... numbers) {
        double division = numbers[0];
        for (int i = 1; i<numbers.length; i++){
            division /= numbers[i];
        }
        return formatNumber(division);
    }

    @Override
    public double divide(double... numbers) {
        double division = numbers[0];
        for (int i = 1; i<numbers.length; i++){
            division /= numbers[i];
        }
        return formatNumber(division);
    }

    protected double formatNumber (double n){
        //convert the result (division) into a string, modify the number of decimals, then convert it back to int
        String s = String.format("%."+defaultDecimals+"f", n);
        // convert the string back to int;
        return Double.parseDouble(s);
    }
}
