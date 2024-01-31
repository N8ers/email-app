package com.nathan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmailGeneratorTest {
  @Test
  public void shouldReturnDummyString() {
    String email = "tsuki@cat.com";
    String dummyString = "hi";

    String result = EmailGenerator.generateEmail(email);

    assertEquals(result, dummyString);
  }

  @Test
  public void shouldThrowIfNoAtSign() {
    String email = "tsuki";

    try {
      EmailGenerator.generateEmail(email);
      throw new IllegalArgumentException("TEST FIALED");
    } catch (IllegalArgumentException ex) {
      assertEquals("Email is wrong!", ex.getMessage());
    }
  }

}
