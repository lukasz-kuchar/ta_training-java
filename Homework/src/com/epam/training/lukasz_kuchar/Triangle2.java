package com.epam.training.lukasz_kuchar;

class Triangle2 extends Figure {
    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;
    Point p1;
    Point p2;
    Point p3;
    Point[] points = new Point[3];

    Triangle (Point p1, Point p2, Point p3){
        x1 = p1.getX();
        y1 = p1.getY();
        x2 = p2.getX();
        y2 = p2.getY();
        x3 = p3.getX();
        y3 = p3.getY();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.points[0] = p1;
        this.points[1] = p2;
        this.points[2] = p3;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Point leftmostPoint(){
        Point leftmost = points[0];
        for(int i=1; i<points.length; i++){
            if(points[i].getX() < leftmost.getX()){
                leftmost = points[i];
            }
        }
        return leftmost;
    }

    @Override
    public double area(){

        return Math.abs(0.5*(x1*(y2-y3) + x2*(y3 - y1) + x3*(y1 - y2)));
    }

    @Override
    public String pointsToString(){
        return p1.toString() + p2.toString() + p3.toString();
    }

    public static void main(String[] args) {

        Figure t1 = new Triangle(new Point(3, 4), new Point(8, 2), new Point(6, 9));

        //(3.0,4.0)(8.0,2.0)(6.0,9.0)

        System.out.println(t1.toString());
        System.out.println(t1.leftmostPoint().toString());


    }

}
