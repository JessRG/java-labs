package com.acme.utils;

/**
 *
 */
public class MyDate {

    // Add attributes
    public int day;
    public int year;
    public int month;

    // Initialization Block
    {
        month = 1;
        day = 1;
        year = 2000;
    }

    // No-arg Constructor
    public MyDate() {
    }

    /**
     * @param m
     * @param d
     * @param y
     */
    public MyDate(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

    //
    public void setDate(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    public static void leapYears() {
        // ...your code here to compute and println the leap years.
        int year = 2020;
        for (int i = 1752; i < year; i++) {
            if ( (i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                System.out.printf("%d is a leap year!\n", i);
            }
        }
    }
}
