package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
    //    Square.PrintSquareArea(new Square(7.0));
    //    Square.PrintSquareArea(new Square(5.0));
    //   Square.PrintSquareArea(new Square(3.0));

    //    Rectangle.printRectangleArea (3.0,5.0);
    //     Rectangle.printRectangleArea (7.0,11.0);

        Triangle.PrintTriangleArea(new Triangle(5.0,4.0,3.0));
        Triangle.PrintTrianglePerimeter(new Triangle(5.0,4.0,3.0));
    }

}
