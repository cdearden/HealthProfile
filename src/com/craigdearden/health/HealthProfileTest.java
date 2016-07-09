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
import java.util.regex.Pattern;

public class HealthProfileTest {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
   
    
    Scanner sc = new Scanner(System.in);

    String lastName = "";
    HealthProfile.Gender gender = null;
    LocalDate dateOfBirth = null;
    double height = 0.0d;
    double weight = 0.0d;

    System.out.println("Please enter patient information: ");
    System.out.print("First name: ");
    String firstName = sc.nextLine();

    System.out.print("Last name: ");
    lastName = sc.nextLine();

    System.out.println("Gender: ");
    String input = sc.nextLine();
    if (input.contains("male")) {
      gender = HealthProfile.Gender.MALE;
    } else if (input.contains("female")) {
      gender = HealthProfile.Gender.FEMALE;
    } else {
      System.out.println("Invalid input!");
    } 

    System.out.println("Date Of Birth: ");
    Pattern pattern = Pattern.compile("[0-1]\\d/[0-3]\\d/\\d\\d\\d\\d");
    try {
      String date = sc.next(pattern);
      DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy");
      dateOfBirth = LocalDate.parse(date, f);
    } catch (NoSuchElementException | DateTimeParseException e) {
      System.out.println("Invalid date!");
    }

    System.out.println("Height(in): ");
    try {
      height = sc.nextDouble();
    } catch (NoSuchElementException e) {
      System.out.println("Invalid input!");
    }

    System.out.println("Weight(lbs): ");
    try {
      weight = sc.nextDouble();
    } catch (NoSuchElementException e) {
      System.out.println("Invalid input!");
    }

    HealthProfile profile = new HealthProfile(firstName, lastName, gender,
        dateOfBirth, height, weight);

    profile.print();
  }

}
