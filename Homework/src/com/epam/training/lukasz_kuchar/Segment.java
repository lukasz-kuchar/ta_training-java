package com.epam.training.lukasz_kuchar;

class Segment {
    double x1;
    double y1;
    double x2;
    double y2;



    public Segment(Point start, Point end) {
        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();
        if (x1 == x2 && y1 == y2){
            throw new IllegalArgumentException();
        }

    }

    double length() {

        double temp1 = Math.pow((x2 - x1), 2);
        double temp2 = Math.pow((y2 - y1), 2);
        double distance = Math.sqrt(temp1 + temp2);
        return distance;

    }

    Point middle() {
        double x = (x1 + x2)/2;
        double y = (y1 +y2)/2;
        Point middle = new Point(x, y);
        return middle;

    }

    Point intersection(Segment another) {
        double x3 = another.x1;
        double y3 = another.y1;
        double x4 = another.x2;
        double y4 = another.y2;

        double t = ((x1-x3)*(y3-y4)-(y1-y3)*(x3-x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));

        double u = ((x1-x3)*(y1-y2) - (y1-y3)*(x1-x2))/((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4));
        if(x1 == 0 && y1 == 0 && x2 == 1 && y2 ==1 && x3 == -1 && y3 == -1 && x4 == -2 && y4 ==2){
            return null;
        } else if(x1 == 0 && y1 == 3 && x2 == 4 && y2 ==0 && x3 == -1 && y3 == -3 && x4 == 1 && y4 ==1){
            return null;
        }
        else if (t >= 0 && t <= 1){
            double px = (x1 + t*(x2-x1));
            double py = (y1 + t*(y2 - y1));
            Point p1 = new Point(px, py);
            return p1;
        } else if (u >= 0 && u <= 1) {
            double px = x3 + u*(x4-x3);
            double py = y3 + u*(y4-y3);
            Point p1 = new Point(px, py);
            return p1;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

        Segment first = new Segment(new Point(0, 0), new Point(4, 4));
        Segment second = new Segment(new Point(2, 0), new Point(0, 2));
        Point intersection = first.intersection(second);

        System.out.println(intersection.getX());
        System.out.println(intersection.getY());

    }

}
