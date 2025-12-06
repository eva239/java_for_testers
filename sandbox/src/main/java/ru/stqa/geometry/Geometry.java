package ru.stqa.geometry;

import ru.stqa.geometry.figures.Square;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100.0));
        var squares = Stream.generate(randomSquare).limit(5);
        Consumer<Square> print = square -> {
            Square.PrintSquareArea(square);
       // Square.PrintPerimeter(square);
        };
     //   squares.peek().forEach(print);

//        Rectangle.printRectangleArea (3.0,5.0);
//         Rectangle.printRectangleArea (7.0,11.0);
//
//        Triangle.PrintTriangleArea(new Triangle(5.0,4.0,3.0));
//        Triangle.PrintTrianglePerimeter(new Triangle(5.0,4.0,3.0));
    }

}
