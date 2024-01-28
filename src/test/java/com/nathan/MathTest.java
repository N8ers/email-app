package com.nathan;

import static org.junit.Assert.assertEquals;
import java.util.Random;

import org.junit.Test;

public class MathTest {
  @Test
  public void shouldReturnSumOf2And2() {
    int expectedResult = 2 + 2;
    int actual = Math.sum(2, 2);
    assertEquals(expectedResult, actual);
  }

  @Test
  public void shouldReturnSumOfRandomArguments() {
    Random rand = new Random();
    int rand_int1 = rand.nextInt(100);
    int rand_int2 = rand.nextInt(100);

    int expectedResult = rand_int1 + rand_int2;
    int actual = Math.sum(rand_int1, rand_int2);
    assertEquals(expectedResult, actual);
  }
}
