/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.health;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HealthProfileTest {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    HealthProfile profile = new HealthProfile();
    String firstName = "";
    String lastName = "";
    HealthProfile.Gender gender = null;
    LocalDate dateOfBirth = null;
    double height = 0.0d;
    double weight = 0.0d;
    boolean invalidInput = true;

    System.out.println("Please enter patient information: ");

    do {
      try {
        System.out.print("First name: ");
        firstName = sc.nextLine();
        if(!firstName.trim().matches("[a-zA-Z-']+"))
          throw new IllegalArgumentException("Invalid name");
        profile.setFirstName(firstName.trim());
        invalidInput = false;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    } while (invalidInput);

    invalidInput = true;
    do {
      try {
        System.out.print("Last name: ");
        lastName = sc.nextLine();
        if(!lastName.trim().matches("[a-zA-Z-']+"))
          throw new IllegalArgumentException("Invalid name");
        profile.setLastName(lastName.trim());
        invalidInput = false;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    } while (invalidInput);

    invalidInput = true;
    do {
      System.out.println("Gender: ");
      String input = sc.nextLine();
      if (input.contains("female")) {
        gender = HealthProfile.Gender.FEMALE;
        profile.setGender(gender);
        invalidInput = false;
      } else if (input.contains("male")) {
        gender = HealthProfile.Gender.MALE;
        profile.setGender(gender);
        invalidInput = false;
      } else {
        System.out.println("Invalid input!");
      }
    } while (invalidInput);

    invalidInput = true;
    do {
      try {
        System.out.println("Date Of Birth (MM/DD/YYYY): ");
        String date = sc.next();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        dateOfBirth = LocalDate.parse(date, f);
        profile.setDateOfBirth(dateOfBirth);
        invalidInput = false;
      } catch (NoSuchElementException | DateTimeParseException | IllegalArgumentException e) {
        System.out.println("Invalid date!");
        sc.nextLine();
      }
    } while (invalidInput);

    invalidInput = true;
    do {
      try {
        System.out.println("Height(in): ");
        height = sc.nextDouble();
        profile.setHeight(height);
        invalidInput = false;
      } catch (NoSuchElementException | IllegalArgumentException e) {
        System.out.println("Invalid input!");
        sc.nextLine();
      }
    } while (invalidInput);

    invalidInput = true;
    do {
      try {

        System.out.println("Weight(lbs): ");
        weight = sc.nextDouble();
        profile.setWeight(weight);
        invalidInput = false;
      } catch (NoSuchElementException | IllegalArgumentException e) {
        System.out.println("Invalid input!");
        sc.nextLine();
      }
    } while (invalidInput);

    profile.print();
  }

}
