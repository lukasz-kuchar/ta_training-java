package com.epam.training.lukasz_kuchar;

class Quadrilateral extends Figure {
    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;
    double x4;
    double y4;
    Point p1;
    Point p2;
    Point p3;
    Point p4;
    Point[] points = new Point[4];


    Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        x1 = p1.getX();
        y1 = p1.getY();
        x2 = p2.getX();
        y2 = p2.getY();
        x3 = p3.getX();
        y3 = p3.getY();
        x4 = p4.getX();
        y4 = p4.getY();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.points[0] = p1;
        this.points[1] = p2;
        this.points[2] = p3;
        this.points[3] = p4;

    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String pointsToString(){
        return p1.toString() + p2.toString() + p3.toString() + p4.toString();
    }

    @Override
    public double area(){
        double area1 = new Triangle(this.p1, this.p2, this.p3).area();
        double area2 = new Triangle(this.p3, this.p4, this.p1).area();
        return Math.abs(area1 + area2);
    }

    @Override
    public Point leftmostPoint(){
        Point leftmost = points[0];
        for(int i=1; i<points.length; i++){
            if(points[i].getX() < points[i-1].getX()){
                leftmost = points[i];
            }
        }
        return leftmost;
    }

    public static void main(String[] args) {
        Figure q1 = new Quadrilateral(new Point(1,0), new Point(2, 1), new Point(1, 2), new Point(0, 1));
        System.out.println(q1.toString());
        System.out.println(q1.leftmostPoint().toString());
    }


}

