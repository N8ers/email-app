package com.nathan;

public class EmailGenerator {
  /**
   * static means that the variable or method marked as
   * such is available at the class level. In other words,
   * you don't need to create an instance of the class to access it.
   */
  public static String generateEmail(String email) {
    String[] emailParts = email.split("@");
    if (emailParts.length != 2) {
      throw new IllegalArgumentException("Invalid email.");
    }

    String username = emailParts[0];
    String domain = emailParts[1];
    String appendedEmail = username + "+1@" + domain;

    return appendedEmail;
  }
}
