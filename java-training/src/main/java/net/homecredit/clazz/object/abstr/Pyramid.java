package net.homecredit.clazz.object.abstr;

public class Pyramid extends Triangle {

    @Override
    public Point3D[] getCoordinates() {
           return new Point3D[]{
                   new Point3D(0, 0, 0),
                   new Point3D(0, 10, 0),
                   new Point3D(10, 0,0),
                   new Point3D(10, 10, 0),
                   new Point3D(5, 5,10)}; // summit
    }
}
