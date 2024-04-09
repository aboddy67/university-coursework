package Lab9_AbstractClassesAndInterfaces;

public interface Shape {
    public double area();
    public double volume();
    // we don't need to make it abstract because it is by default.
    public String getName();
}
