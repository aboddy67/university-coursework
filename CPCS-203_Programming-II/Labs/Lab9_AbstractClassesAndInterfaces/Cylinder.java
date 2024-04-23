/*
Name: Abdulrahman Adnan Thigah
*/
package Lab9_AbstractClassesAndInterfaces;

public class Cylinder extends Circle {
    protected double height;

    public Cylinder() {
        setHeight(0);
    }
    public Cylinder(double cylinderHeight, double cylinderRadius, int xCoordinate, int yCoordinate) {
        super(cylinderRadius, xCoordinate, yCoordinate);
        setHeight(cylinderHeight);
    }
    public void setHeight(double cylinderHeight) {
        height = (cylinderHeight >= 0 ? cylinderHeight : 0);
    }
    public double getHeight() {
        return height;
    }
    // calculate area of cylinder (i.e, surface  area)

    @Override
    public double area() {
        return 2 * super.area() + 2 * Math.PI * radius * height;
    }
    @Override
    public double volume() {
        return super.area() * height;
    }
    @Override
    public String toString() {
        return String.format("%s; Height = %f", super.toString(), height);
    }
    @Override
    public String getName() {
        return "Cylinder";
    }
}
