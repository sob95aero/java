package net.homecredit.clazz.object.abstr;

public class Triangle extends Shape {

    @Override
    public Point[] getCoordinates() {
        return new Point[]{new Point(0, 0), new Point(0, 10), new Point(10, 0)};
    }

}
