package com.acme.utils;

/**
 *
 */
public class MyDate {

    // Add attributes
    private byte day;
    private byte month;
    private short year;
    private static MyDate[] holidays;

    // Initialization Block
    {
        month = 1;
        day = 1;
        year = 2000;
    }

    static {
        holidays = new MyDate[6];
        holidays[0] = new MyDate(1, 1, 2016);
        holidays[1] = new MyDate(9, 5, 2016);
        holidays[2] = new MyDate(5, 30, 2016);
        holidays[3] = new MyDate(11, 24, 2016);
        holidays[4] = new MyDate(7, 4, 2016);
        holidays[5] = new MyDate(12, 25, 2016);
    }

    // No-arg Constructor
    public MyDate() {
        this(1, 1, 1990);
    }

    /**
     * @param m
     * @param d
     * @param y
     */
    public MyDate(int m, int d, int y) {
        setDate(m, d, y);
    }

    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

    //
    public void setDate(int m, int d, int y) {
        if(valid(d, m, y)) {
            month = (byte) m;
            day = (byte) d;
            year = (short) y;
        }
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

    private boolean valid(int day, int month, int year){
        if (day > 31 || day < 1 || month > 12 || month < 1 ){
            System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
            return false;
        }
        switch (month){
            case 4:
            case 6:
            case 9:
            case 11: return (day <= 30);
            case 2: return day <= 28 || ( day == 29 && year % 4 == 0) ;
        }
        return true;
    }

    public boolean equals(Object o) {
        if (o instanceof MyDate) {
            MyDate d = (MyDate) o;
            if( (d.day == day) && (d.month == month) && (d.year == year) ) {
                return true;
            }
        }
        return false;
    }

    public static void listHolidays() {
        System.out.println("the holidays are:");
        for ( MyDate holiday : holidays) {
            System.out.println(holiday);
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(valid(day, this.month, this.year)) {
            this.day = (byte) day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(valid(this.day, month, this.year)) {
            this.month = (byte) month;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(valid(this.day, this.month, year)) {
            this.year = (short) year;
        }
    }

    public static MyDate[] getHolidays() {
        return holidays;
    }

    public static void setHolidays(MyDate[] holidays) {
        MyDate.holidays = holidays;
    }
}
