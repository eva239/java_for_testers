package ru.stqa.geometry.figures;

public class Triangle {
    private double a;
    private double b;
    private double c;
    public Triangle (double a, double b, double c){
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

}

