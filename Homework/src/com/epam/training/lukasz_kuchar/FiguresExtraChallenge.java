package com.epam.training.lukasz_kuchar;

public class FiguresExtraChallenge {
}

Circle class
---
        package com.epam.rd.autotasks.figures;

        import java.util.ArrayList;
        import java.util.List;

        import static java.lang.Math.sqrt;

class Circle extends Figure {
    Point center;
    double radius;
    List<Point> vertices = new ArrayList<>();

    Circle(Point p1, double radius) {
        if(p1 == null){
            throw new IllegalArgumentException();
        }
        if (radius <= 0) {
            throw new IllegalArgumentException();


        } else {
            this.center = p1;
            this.radius = radius;
            this.vertices.add(p1);
        }
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public Point centroid() {
        return this.center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Circle) {
            Circle otherCircle = (Circle) figure;

            // Check if the circles have the same radius and center (within a certain delta)
            double delta = 0.0001; // Adjust the delta as needed
            boolean sameRadius = Math.abs(this.radius - otherCircle.radius) < delta;
            boolean sameCenter = Math.abs(this.center.getX() - otherCircle.center.getX()) < delta &&
                    Math.abs(this.center.getY() - otherCircle.center.getY()) < delta;

            return sameRadius && sameCenter;
        }

        return false; // If the input figure is not a Circle
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2) * sqrt(2));
        System.out.println(4 - sqrt(2) * sqrt(2));
        System.out.println(sqrt(3) * sqrt(3));
        /*Circle c1 = new Circle(new Point(0,0), 3);
        Circle c2 = new Circle(new Point(0,0), 3);
        boolean isSame = c1.isTheSame(c2);
        System.out.println(isSame);*/
    }
}
---

        Triangle class
---
        package com.epam.rd.autotasks.figures;

        import java.util.ArrayList;
        import java.util.List;

class Triangle extends Figure{

    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;
    Point p1;
    Point p2;
    Point p3;
    List<Point> vertices = new ArrayList<>();

    Triangle (Point a, Point b, Point c){
        if(a == null || b == null || c == null){
            throw new IllegalArgumentException();
        }
        x1 = a.getX();
        y1 = a.getY();
        x2 = b.getX();
        y2 = b.getY();
        x3 = c.getX();
        y3 = c.getY();
        this.p1 = a;
        this.p2 = b;
        this.p3 = c;
        this.vertices.add(a);
        this.vertices.add(b);
        this.vertices.add(c);

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

    @Override
    public Point centroid() {
        double xc = (this.x1 + this.x2 + this.x3)/3;
        double yc = (this.y1 + this.y2 + this.y3)/3;
        return new Point(xc, yc);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Triangle) {
            Triangle otherTriangle = (Triangle) figure;
            int matches = 0;

            // Check if the circles have the same radius and center (within a certain delta)
            double delta = 0.0001; // Adjust the delta as needed
            for(int i=0; i<this.vertices.size(); i++){
                for(int j=0; j<otherTriangle.vertices.size(); j++){
                    if(Math.abs(this.vertices.get(i).getX()) - otherTriangle.vertices.get(j).getX() < delta &&
                            Math.abs(this.vertices.get(i).getY()) - otherTriangle.vertices.get(j).getY() < delta){
                        matches++;
                    }
                }
            } if(matches == 3){
                return true;
            }
        }

        return false; // If the input figure is not a Triangle
    }
    public double area() {
        return Math.abs(0.5*(x1*(y2-y3) + x2*(y3 - y1) + x3*(y1 - y2)));
    }

    public static void main(String[] args) {
        Figure t1 = new Triangle(new Point(0,0), new Point(3,0),new Point(0, 4));
        Figure t2 = new Triangle(new Point(0,0), new Point(3,0),new Point(0, 4));
        System.out.println(t1.isTheSame(t2));
    }

}

---


        Quadriliteral class
---
        package com.epam.rd.autotasks.figures;

        import java.util.ArrayList;
        import java.util.List;

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
    List<Point> vertices = new ArrayList<>();

    Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        if (p1 == null || p2 == null || p3 == null || p4 == null) {
            throw new IllegalArgumentException();
        }
        if (!isConvex(p1, p2, p3, p4)) {
            throw new IllegalArgumentException();
        }
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
        this.vertices.add(p1);
        this.vertices.add(p2);
        this.vertices.add(p3);
        this.vertices.add(p4);
    }


    private boolean isConvex(Point p1, Point p2, Point p3, Point p4) {
        double crossProduct1 = crossProduct(p1, p2, p3);
        double crossProduct2 = crossProduct(p2, p3, p4);
        double crossProduct3 = crossProduct(p3, p4, p1);
        double crossProduct4 = crossProduct(p4, p1, p2);

        return (crossProduct1 > 0 && crossProduct2 > 0 && crossProduct3 > 0 && crossProduct4 > 0) ||
                (crossProduct1 < 0 && crossProduct2 < 0 && crossProduct3 < 0 && crossProduct4 < 0);
    }

    private double crossProduct(Point p1, Point p2, Point p3) {
        return (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) -
                (p3.getX() - p1.getX()) * (p2.getY() - p1.getY());
    }


    @Override
    public Point centroid() {
        // Calculate centroids for all four triangles formed by breaking the quadrilateral
        Point centroidTriangle1 = calculateTriangleCentroid(x1, y1, x2, y2, x3, y3);
        Point centroidTriangle2 = calculateTriangleCentroid(x1, y1, x4, y4, x3, y3);
        Point centroidTriangle3 = calculateTriangleCentroid(x2, y2, x3, y3, x4, y4);
        Point centroidTriangle4 = calculateTriangleCentroid(x2, y2, x4, y4, x1, y1);

        // Calculate the intersection point of lines formed by centroids
        double x1 = centroidTriangle1.getX();
        double y1 = centroidTriangle1.getY();
        double x2 = centroidTriangle2.getX();
        double y2 = centroidTriangle2.getY();
        double x3 = centroidTriangle3.getX();
        double y3 = centroidTriangle3.getY();
        double x4 = centroidTriangle4.getX();
        double y4 = centroidTriangle4.getY();

        // Calculate the intersection point using line equations
        double intersectionX = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) /
                ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double intersectionY = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) /
                ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));

        return new Point(intersectionX, intersectionY);
        //return centroidTriangle1;
    }

    private Point calculateTriangleCentroid(double x1, double y1, double x2, double y2, double x3, double y3) {
        double xc = (x1 + x2 + x3) / 3;
        double yc = (y1 + y2 + y3) / 3;
        return new Point(xc, yc);
    }

    @Override
    public double area () {
        double area1 = new Triangle(this.p1, this.p2, this.p3).area();
        double area2 = new Triangle(this.p3, this.p4, this.p1).area();
        return Math.abs(area1 + area2);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Quadrilateral) {
            Quadrilateral other = (Quadrilateral) figure;
            int matches = 0;

            // Check if the circles have the same radius and center (within a certain delta)
            double delta = 0.0001; // Adjust the delta as needed
            for(int i=0; i<this.vertices.size(); i++){
                for(int j=0; j<other.vertices.size(); j++){
                    if(Math.abs(this.vertices.get(i).getX() - other.vertices.get(j).getX()) < delta &&
                            Math.abs(this.vertices.get(i).getY() - other.vertices.get(j).getY()) < delta) {
                        matches++;
                    }
                }
            } if(matches == 4){
                return true;
            }
        }

        return false; // If the input figure is not a Triangle
    }


    public static void main (String[]args){

        Figure c1 = new Quadrilateral(new Point(0,0), new Point(3,0), new Point(3,2), new Point(0,3));
        Point centroid = c1.centroid();
        System.out.println(centroid.toString());

    }
}

---

        Figure class
---
        package com.epam.rd.autotasks.figures;

        import java.util.List;

abstract class Figure{
    //private static final double ERROR_DELTA = 1e-15;
    public List<Point> vertices;

    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);

    public abstract double area();

}

---

        point class
---
        package com.epam.rd.autotasks.figures;

        import java.util.Objects;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return Double.compare(other.x, x) == 0 && Double.compare(other.y, y) == 0;
    }

}

---

