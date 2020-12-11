package com.acme.testing;

import com.acme.utils.MyDate;

public class TestMyDate{

    /**
     * TestMyDate main method
     * @param args
     */
    public static void main(String[] args){
        // Test initialization block
        MyDate date4 = new MyDate();
        String str4 = date4.toString();
        System.out.println(str4);

        // Test MyDate methods, no-arg constructor, and constructor
        MyDate date1 = new MyDate(11,11,1918);
        MyDate date2 = new MyDate();
        date2.setDay(11);
        date2.setMonth(11);
        date2.setYear(1918);
        MyDate date3 = new MyDate();
        date3.setDate(4,21,1968);
        date3.setDate(13,40,-1);
        String str1 = date1.toString();
        String str2 = date2.toString();
        String str3 = date3.toString();
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        MyDate.leapYears();

        MyDate newYear = new MyDate(1,1,2000);
        MyDate fiscalStart = new MyDate(1,1,2000);

//        String newYear = "sameString";
//        String fiscalStart = "sameString";

        if(newYear.equals(fiscalStart)) {
            System.out.println("These two dates are equal");
        } else {
            System.out.println("These two dates are not equal.");
        }

        MyDate.listHolidays();
    }
}