package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculateArea() {
        var t = new Triangle(5.0,4.0, 3.0);
        double result = t.area();
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void canCalculatePerimeter() {
        var t = new Triangle(5.0,4.0, 3.0);
        double result = t.perimeter();
        Assertions.assertEquals(12.0, result);
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 3.0, 4.0);
            Assertions.fail("Triangle side should be not-negative");
        } catch (IllegalArgumentException exception) {
            System.out.println("Ловим исключение: " + exception.getMessage());
        }
    }
    @Test
    void TriangleInequalityCheck() {
        try {
            new Triangle(1.0, 3.0, 5.0);
            Assertions.fail("Triangle inequality violation");
        } catch (IllegalArgumentException exception) {
            System.out.println("Ловим исключение: " + exception.getMessage());
        }
    }
    @Test
    void TestEquality(){
        var t1 = new Triangle(3.0,4.0,5.0);
        var t2 = new Triangle(5.0,3.0,4.0);
        Assertions.assertEquals(t1,t2);
    }
}
