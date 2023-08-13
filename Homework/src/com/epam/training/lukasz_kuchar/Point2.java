package com.epam.training.lukasz_kuchar;

class Point2 {
    private double x;
    private double y;

    @Override
    public String toString() {

        return String.format("(%1$.1f", x).replace(",", ".") + "," + String.format("%1$.1f)", y).replace(",", ".");
    }

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static void main(String[] args) {
        Point p1 = new Point(2.5, 3);
        System.out.println(p1);
    }

}
