package com.epam.training.lukasz_kuchar;

class Circle extends Figure{
    Point p1;
    double radius;

    Circle (Point p1, double radius){
        this.p1 = p1;
        this.radius = radius;
    }

    @Override
    public double area(){

        return (Math.PI)*radius*radius;
    }

    @Override
    public String pointsToString(){
        return p1.toString();
    }

    @Override
    public String toString() {
        return "Circle" + "[" + p1.toString() + radius + "]";
    }

    @Override
    public Point leftmostPoint(){
        Point leftmost = new Point(p1.getX()-radius,p1.getY());

        return leftmost;
    }

    public static void main(String[] args) {
        Figure c1 = new Circle(new Point(0,0), 3);


        System.out.println(c1.toString());
        System.out.println(c1.leftmostPoint().toString());

    }

}