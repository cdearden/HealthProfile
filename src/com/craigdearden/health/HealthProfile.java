/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.health;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class HealthProfile {

  public enum Gender {
    MALE, FEMALE
  };

  private String firstName;
  private String lastName;
  private Gender gender;
  private LocalDate dateOfBirth;
  
  /**
   * Person's height in inches.
   */
  private double height;
  
  /**
   * Person's weight in pounds.
   */
  private double weight;

  public HealthProfile(String firstName, String lastName, Gender gender, LocalDate dateOfBirth,
      double height, double weight) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.height = height;
    this.weight = weight;
  }

  /**
   * @return person's age in years.
   */
  public int getAge() {
    return (int) Period.between(dateOfBirth, LocalDate.now()).get(ChronoUnit.YEARS);
  }

  /**
   * @return calculated maximum heart rate.
   */
  public int getMaxHeartRate() {
    return 220 - getAge();
  }

  /**
   * Calculates the heart rate range which is 50-80% of the person's maximum heart rate.
   * @return the target heart range.
   */
  public int[] getTargetHeartRateRange() {
    int max = (int) (getMaxHeartRate() * 0.85);
    int min = (int) (getMaxHeartRate() * 0.50);
    int[] range = new int[]{min, max};
    return range;
  }

  /**
   *  Calculates the Body Mass Index.
   * @return the body mass index.
   */
  public double getBMI() {
    return (weight * 703) / Math.pow(height, 2);
  }

  /**
   * Prints persons information.
   */
  public void print() {
    int[] range = getTargetHeartRateRange();
    System.out.printf(
        "%-20s %20s %n%-20s %20s %n%-20s %20s %n%-20s %20s %n%-20s %20.1f %n%-20s %20.1f %n%-20s %20d %n%-20s"
        + " %20d %n%-20s %20s %n%-20s %20.1f", "First name: ", firstName, "Last name: ", lastName,
        "Gender: ", gender, "Birth Date: ", dateOfBirth, "Height(in): ", height,
        "Weight(lbs): ", weight, "Age: ", getAge(), "Max Heart Rate: ", getMaxHeartRate(),
        "Heart Rate Range: ", range[0] + "-" + range[1], "BMI: ", getBMI()
    );
    System.out.println("\n\nBMI Chart:\n" + "Underweight: less than 18.5\n"
        + "Normal: between 18.5 and 24.9\n" + "Overweight: between 25 and 29.9\n"
        + "Obese: 30 or greater");
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the gender
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * @param gender the gender to set
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * @return the dateOfBirth
   */
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * @param dateOfBirth the dateOfBirth to set
   */
  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * @return the height
   */
  public double getHeight() {
    return height;
  }

  /**
   * @param height the height to set
   */
  public void setHeight(double height) {
    this.height = height;
  }

  /**
   * @return the weight
   */
  public double getWeight() {
    return weight;
  }

  /**
   * @param weight the weight to set
   */
  public void setWeight(double weight) {
    this.weight = weight;
  }

}
