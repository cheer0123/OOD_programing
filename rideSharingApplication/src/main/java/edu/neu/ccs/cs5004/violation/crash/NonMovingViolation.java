package edu.neu.ccs.cs5004.violation.crash;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class represents a NonMovingViolation. A NonMovingViolation has a Type and the date of
 * violation.
 */
public class NonMovingViolation {

  private NonMovingViolationType type;
  private  LocalDate dateOfViolation;

  public static enum NonMovingViolationType {
    ParkingViolation, PaperworkIssues, VehicleProblems
  }
  /**
   * construct a NonMovingViolation that has a Type and date.
   *
   * @param dateOfViolation the date of violation
   * @param type the type of violation
   */
  public NonMovingViolation(NonMovingViolationType type, LocalDate dateOfViolation) {
    this.type = type;
    this.dateOfViolation = dateOfViolation;
  }

  /**
   * return the type of violation.
   *
   * @return the type of violation
   */
  public NonMovingViolationType getType() {
    return type;
  }
  /**
   * return the date of violation.
   *
   * @return the date of violation
   */
  public LocalDate getDateOfViolation() {
    return dateOfViolation;
  }

  /**
   * Return a boolean whether they are equal.
   *
   * @param object the object to compare
   * @return a boolean whether they are equal
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof NonMovingViolation)) {
      return false;
    }
    NonMovingViolation that = (NonMovingViolation) object;
    return type == that.type && dateOfViolation.equals(that.dateOfViolation);
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(type, dateOfViolation);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "NonMovingViolation{" + "type=" + type + ", dateOfViolation=" + dateOfViolation + '}';
  }
}
