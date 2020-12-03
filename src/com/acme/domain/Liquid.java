package com.acme.domain;

public class Liquid extends Good {
    private double radius;

    public Liquid(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable, double wgtPerUoM, double radius) {
        super(name, modelNumber, height, uoM, flammable, wgtPerUoM);
        this.radius = radius;
    }

    public double volume() {
        return Math.PI * Math.pow(radius, 2) * getHeight();
    }

    public String toString() {
        return super.toString() + " (liquid) " + volume() + " " + getUnitOfMeasure();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
