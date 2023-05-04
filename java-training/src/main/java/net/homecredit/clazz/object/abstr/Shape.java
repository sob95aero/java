package net.homecredit.clazz.object.abstr;

public abstract class Shape {

    public abstract Point[] getCoordinates();

    public String draw() {
        Point[] coordinates = getCoordinates();
        return getDrawing(coordinates);
    }

    public String draw(Point[] coordinates) {
        return getDrawing(coordinates);
    }

    public String draw(String stupid) {
        return stupid;
    }

    private String getDrawing(Point[] coordinates) {
        System.out.println("-----------------");
        System.out.println(this.getClass());
        StringBuilder sb = new StringBuilder();
        for (Point coordinate : coordinates) {

            System.out.println(coordinate);
            sb.append(coordinate);
            sb.append("; ");
        }
        return sb.toString().trim();
    }


}
