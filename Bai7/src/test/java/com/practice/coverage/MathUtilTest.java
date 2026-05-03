package com.practice.coverage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for MathUtil class.
 */
public class MathUtilTest {

    @Test
    public void testAdd() {
        MathUtil mathUtil = new MathUtil();
        assertEquals(5, mathUtil.add(2, 3), "2 + 3 should be 5");
    }
}