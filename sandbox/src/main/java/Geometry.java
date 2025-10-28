public class Geometry {
    public static void main(String[] args) {
        PrintSquareArea(7.0);
        PrintSquareArea(5.0);
        PrintSquareArea(3.5);

        printRectangleArea (3.0,6.0);
    }

    private static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со стороной " + a + " и "+ b + " = " + rectangleArea(a, b));
    }

    private static double rectangleArea(double a, double b) {

        return a * b;
    }

    static void PrintSquareArea (double a) {
        System.out.println("Площадь квадрата со стороной " + a + " = "+ squareArea(a));

    }

    private static double squareArea(double a) {
        return a * a;
    }
}
