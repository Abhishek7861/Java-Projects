package io.JUnitTesting;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    static void BeforeAllInit(){
        System.out.println("Starting Testing");
    }

    @AfterAll
    static void AfterAllInit(){
        System.out.println("Test Complete");
    }

    @BeforeEach
    void init(){
        System.out.println("Creating instance");
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanUp(){
        System.out.println("Cleaning up...");
    }

    @Test
    @Disabled
    @DisplayName("MY FUNNY FUNCTION")
    void test(){
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected,actual,"The Expected and Actual should be same");
    }


    @Test
    @EnabledOnOs(OS.LINUX)
    void testComputeCircleRadius(){
        assertEquals(314, mathUtils.computeCircleArea(10),
                "Should return correct circle area");
    }

    @Test
    void testDivide(){
        assertThrows(ArithmeticException.class,
                ()-> mathUtils.division(1,0), "divide by zero");
    }
}
