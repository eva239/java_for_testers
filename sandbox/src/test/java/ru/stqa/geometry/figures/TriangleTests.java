package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculateArea() {
        double result = Triangle.TriangleArea(3.0, 4.0, 5.0);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void canCalculatePerimeter() {

        Assertions.assertEquals(12.0, Triangle.TrianglePerimeter(3.0, 4.0, 5.0));
    }
}
