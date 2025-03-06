package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return area + balconyArea;
    };

    @Override
    public String toString() {
        return "Квартира "
                + "площадью " + getArea()
                + " метров на " + floor
                + " этаже";
    }

    public int compareTo(Home another) {
        var anotherArea = another.getArea();
        return Double.compare(getArea(), anotherArea);
    }
}
// END
