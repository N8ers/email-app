package com.nathan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmailGeneratorTest {
  @Test
  public void shouldThrowIfNoAtSign() {
    String email = "tsuki";

    try {
      EmailGenerator.generateEmail(email);
      throw new IllegalArgumentException("TEST FIALED!");
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid email.", ex.getMessage());
    }
  }

  @Test
  public void shouldReturnEmailAppendedWith() {
    String email = "tsuki@cat.com";
    String expectedResult = "tsuki+1@cat.com";

    String result = EmailGenerator.generateEmail(email);

    assertEquals(result, expectedResult);
  }
}
