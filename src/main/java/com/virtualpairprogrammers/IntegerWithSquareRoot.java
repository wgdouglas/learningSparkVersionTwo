package com.virtualpairprogrammers;

public class IntegerWithSquareRoot {

    private int originalNumber;
    private double squareRoot;

    public IntegerWithSquareRoot(int originalNumber) {
        this.originalNumber = originalNumber;
        this.squareRoot = Math.sqrt(originalNumber);
    }
}
