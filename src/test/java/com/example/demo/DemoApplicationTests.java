package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoApplicationTests {

    @Test
    void testHelloMessage() {
        String message = "Hello from Jenkins-deployed Java app!";
        assertEquals("Hello from Jenkins-deployed Java app!", message);
    }
}