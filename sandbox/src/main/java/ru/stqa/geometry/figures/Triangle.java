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

    public static double TriangleArea(double a, double b,double c) {
        var p = (a + b + c )/ 2;
        var num = p * (p-a) * (p-b) * (p-c);
        var squareTriangle = Math.sqrt(num);
        return squareTriangle;
    }
    public static double TrianglePerimeter(double a, double b,double c) {
        return a + b + c;
    }

    public static void PrintTriangleArea(double a, double b, double c) {
        var text = String.format("Площадь треугольника со сторонами %f, %f, %f = %f", a, b, c, TriangleArea(a, b, c));
        System.out.println(text);
    }

    public static void PrintTrianglePerimeter(double a, double b, double c) {
        var text = String.format("Периметр треугольника со сторонами %f, %f, %f = %f", a, b, c, TrianglePerimeter(a, b, c));
        System.out.println(text);
    }

}

