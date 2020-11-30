package com.acme.utils;

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
    public MyDate() {}

    // Constructor
    public MyDate(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

    public void setDate(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }
}
