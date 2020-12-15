package com.acme.utils;

public class HolidayOrdersNotAllowedException extends Exception {

    // constructor
    public HolidayOrdersNotAllowedException(MyDate date) {
        super("Orders are not allowed to be created on: " + date);
    }
}
