package com.acme.domain;

import com.acme.utils.HolidayOrdersNotAllowedException;
import com.acme.utils.MyDate;

public class Order {
    private MyDate orderDate;
    private double orderAmount = 0.00;
    private String customer;
    private Product product;
    private int quantity;
    private static double taxRate;
    private static Rushable rushable;

    // static initialization block
    static {
        taxRate = 0.05;
    }

    /**
     * @param d
     * @param amt
     * @param c
     * @param p
     * @param q
     */
    public Order(MyDate d, double amt, String c, Product p, int q) {
        try {
            setOrderDate(d);
        } catch(HolidayOrdersNotAllowedException e) {
            System.out.println("The order date for an order cannot be a holiday! Application closing.");
            System.exit(0);
        }
        orderAmount = amt;
        customer = c;
        product = p;
        quantity = q;
    }

    /**
     * @param d
     * @param amt
     * @param c
     */
    public Order(MyDate d, double amt, String c) {
        this(d, amt, c, new Solid("Acme Anvil", 1668, 0.3,
                Good.UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3), 1);
    }

    /**
     * @return
     */
    public String toString() {
        return quantity + " ea. " + product + " for " + customer;
    }

    /**
     * @param newRate
     */
    public static void setTaxRate(double newRate) {
        taxRate = newRate;
    }

    /**
     * @param anAmount
     */
    public static void computeTaxOn(double anAmount) {
        System.out.println("The tax for " + anAmount + " is: " + anAmount * taxRate);
    }

    /**
     * @return
     */
    public double computeTax() {
        System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
        return orderAmount * Order.taxRate;
    }

    public char jobSize() {
        // return the job size for an order
        if (quantity <= 25) {
            return 'S';
        } else if (quantity <= 75) {
            return 'M';
        } else if (quantity <= 150) {
            return 'L';
        }
        return 'X';
    }

    public double computeTotal() {
        double orderTotal = orderAmount;
        double discount = 0;

        char jobSize = this.jobSize();

        switch (jobSize) {
            case 'M':
                discount = orderAmount * 0.01;
                break;
            case 'L':
                discount = orderAmount * 0.02;
                break;
            case 'X':
                discount = orderAmount * 0.03;
                break;
        }

        if(orderAmount > 1500) {
            orderTotal -= discount;
        } else {
            orderTotal = orderTotal - discount + computeTax();
        }

        return orderTotal;
    }

    public boolean isPriorityOrder() {
        boolean priorityOrder = false;
        if (rushable != null) {
            priorityOrder = rushable.isRushable(orderDate, orderAmount);
        }
        return priorityOrder;
    }

    private boolean isHoliday(MyDate proposedDate) {
        boolean result = false;
        for (MyDate holiday : MyDate.getHolidays()) {
            if( holiday.equals(proposedDate) ) {
                result = true;
            }
        }
        return result;
    }

    public MyDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(MyDate orderDate) throws HolidayOrdersNotAllowedException {
        if (isHoliday(orderDate)) {
            System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!");
            throw new HolidayOrdersNotAllowedException(orderDate);
        } else {
            this.orderDate = orderDate;
        }
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        if (orderAmount > 0) {
            this.orderAmount = orderAmount;
        }
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Good product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Attempting to set quantity to a value less than or equal to zero");
        }
    }

    public static double getTaxRate() {
        return taxRate;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public static Rushable getRushable() {
        return rushable;
    }

    public static void setRushable(Rushable rushable) {
        Order.rushable = rushable;
    }
}
