package ru.stqa.geometry.figures;

import java.util.Objects;

public class Triangle {
    private double a;
    private double b;
    private double c;
    public Triangle (double a, double b, double c){
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException ("Triangle side should be not-negative");
        }
        if ((a+b<c)||( a+c <b)||( b+c<a)) {
            throw new IllegalArgumentException ("Triangle inequality violation");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static void PrintTriangleArea(Triangle exampleTriangle) {
        var text = String.format("Площадь треугольника со сторонами %f, %f, %f = %f", exampleTriangle.a, exampleTriangle.b, exampleTriangle.c, exampleTriangle.area());
        System.out.println(text);
    }
    public double area() {
        var p = (this.a + this.b + this.c )/ 2;
        var num = p * (p-this.a) * (p-this.b) * (p-this.c);
        var squareTriangle = Math.sqrt(num);
        return squareTriangle;
    }

    public static void PrintTrianglePerimeter(Triangle exampleTriangle){
        var text = String.format("Периметр треугольника со сторонами %f, %f, %f = %f", exampleTriangle.a, exampleTriangle.b, exampleTriangle.c, exampleTriangle.perimeter());
        System.out.println(text);
    }

    public double perimeter() {
        return (this.a + this.b + this.c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(triangle.a, a) == 0 && Double.compare(triangle.b, b) == 0 && Double.compare(triangle.c, c) == 0)||
               (Double.compare(triangle.a, a) == 0 && Double.compare(triangle.b, c) == 0 && Double.compare(triangle.c, b) == 0)||
               (Double.compare(triangle.a, b) == 0 && Double.compare(triangle.b, a) == 0 && Double.compare(triangle.c, c) == 0)||
               (Double.compare(triangle.a, b) == 0 && Double.compare(triangle.b, c) == 0 && Double.compare(triangle.c, a) == 0)||
               (Double.compare(triangle.a, c) == 0 && Double.compare(triangle.b, a) == 0 && Double.compare(triangle.c, b) == 0)||
               (Double.compare(triangle.a, c) == 0 && Double.compare(triangle.b, b) == 0 && Double.compare(triangle.c, a) == 0);
    }

    @Override
    public int hashCode() {

        return 1;
    }
}

