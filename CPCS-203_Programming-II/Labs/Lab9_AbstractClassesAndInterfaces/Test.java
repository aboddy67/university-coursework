/*
Name: Abdulrahman Adnan Thigah
*/
package Lab9_AbstractClassesAndInterfaces;

public class Test {
    public static void main(String[] args) {
        // create shapes
        Point point = new Point(7, 11);
        Circle circle = new Circle(3.5, 22, 8);
        Cylinder cylinder = new Cylinder(10, 3.3, 10, 10);


        /*
        SO THE PROBLEM OF THE CODE IS THAT CIRCLE AND POINT ARE NOT SUBCLASSES OF CYLINDER
        TO FIX THIS WE CAN MAKE THE ARRAY INTO AN ARRAY OF THE INTERFACE (SHAPE) AND CHANGE THE ARRAY
        TO FIT SHAPES APPLYING POLYMORPHIC IMPLEMENTATION
         */

         /* PROBLEMATIC CODE
        Cylinder arrayOfShapes[] = new Cylinder[3];

        // aim arrayOfShapes[ 0 ] at subclass Point object
        arrayOfShapes[0] = (Cylinder) point;

        // aim arrayOfShapes[ 1 ] at subclass Circle object
        arrayOfShapes[1] = (Cylinder) circle;

        // aim arrayOfShapes[ 2 ] at subclass Cylinder object
        arrayOfShapes[2] = (Cylinder) cylinder;
        */

        // fix ---->

        Shape arrayOfShapes[] = new Shape[3];
        // aim arrayOfShapes[ 0 ] at Point object
        arrayOfShapes[0] = point;

        // aim arrayOfShapes[ 1 ] at Circle object
        arrayOfShapes[1] = circle;

        // aim arrayOfShapes[ 2 ] at Cylinder object
        arrayOfShapes[2] = cylinder;
        // get name and String representation of each shape
        System.out.printf("%s: %s\n%s: %s\n%s: %s\n", point.getName(), point, circle.getName(), circle, cylinder.getName(), cylinder);

        // get name, area and volume of each shape in array of shapes
        for (Shape shape : arrayOfShapes) {
            System.out.printf("\n\n%s: %s\nArea =%.2f\nVolume = %.2f\n", shape.getName(), shape, shape.area(), shape.volume());
        }
    }
}
