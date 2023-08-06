package com.epam.training.lukasz_kuchar;

class Triangle {
    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;

    public Triangle(Point a, Point b, Point c) {
        this.x1 = a.getX();
        this.y1 = a.getY();
        this.x2 = b.getX();
        this.y2 = b.getY();
        this.x3 = c.getX();
        this.y3 = c.getY();
        double sideA = triangleSide(a, b);
        double sideB = triangleSide(b, c);
        double sideC = triangleSide(a, c);

        double angleA = Math.toDegrees(Math.acos((sideC*sideC + sideB*sideB - sideA*sideA)/(2*sideB*sideC)));
        double angleB = Math.toDegrees(Math.acos((sideC*sideC + sideA*sideA - sideB*sideB)/(2*sideA*sideC)));
        double angleC = Math.toDegrees(Math.acos((sideA*sideA + sideB*sideB - sideC*sideC)/(2*sideA*sideB)));
        double sumOfAngles = Math.round(angleA + angleB + angleC);
        if (sideA + sideB < sideC){
            throw new IllegalArgumentException();
        }
        if (Math.round(angleA) == 180 || Math.round(angleB) == 180 || Math.round(angleC) == 180){
            throw new IllegalArgumentException();
        }
        //System.out.println(sumOfAngles);
        if (sumOfAngles != 180){
            throw new IllegalArgumentException();
        }
    }
    public double triangleSide(Point a, Point b) {
        double v1 = a.getX();
        double v2 = a.getY();
        double v3 = b.getX();
        double v4 = b.getY();
        double temp1 = Math.pow((v3 - v1), 2);
        double temp2 = Math.pow((v4 - v2), 2);
        double distance = Math.sqrt(temp1 + temp2);
        return distance;

    }

    public double area() {
        return Math.abs(0.5 * (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)));
    }

    public Point centroid(){
        double xC = (x1 + x2 + x3)/(3.0);
        double yC = (y1 + y2 + y3)/(3.0);
        Point centroid = new Point(xC, yC);
        return centroid;
    }

    public static void main(String[] args) {
        Triangle t1 = new Triangle(new Point(0, 0), new Point(0, 2), new Point(0, 5));
        //Triangle t2 = new Triangle(new Point(0,0), new Point(3, 0), new Point(0, 3));

        /*Point centroid = new Triangle(new Point(0,0), new Point(3, 0), new Point(0, 3)).centroid();
        System.out.println(centroid.getX());
        System.out.println(centroid.getY());*/


    }

}
