package edu.neu.ccs.cs5004.violation.crash;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class represents a MovingViolation. A MovingViolation has a Type and dateOfMovingViolation.
 */
public class MovingViolation {

  private MovingViolationType type;
  private LocalDate dateOfViolation;

  /**
   *Including all MovingViolationType.
   */
  public static enum MovingViolationType {
    DistractedDriving, RecklessDriving,Speeding, DrivingUnderInfluence,
    FailureToRespectTrafficSigns, DrivingWithoutValidLicenseInsurance
  }

  /**
   * construct a MovingViolation that has a Type and date.
   *
   * @param dateOfViolation the date of violation
   * @param type the MovingViolationType
   */
  public MovingViolation(MovingViolationType type, LocalDate dateOfViolation) {
    this.type = type;
    this.dateOfViolation = dateOfViolation;
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
   * return the type of violation.
   *
   * @return the type of violation
   */
  public MovingViolationType getType() {
    return type;
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
    if (!(object instanceof MovingViolation)) {
      return false;
    }
    MovingViolation that = (MovingViolation) object;
    return type == that.type
        && dateOfViolation.equals(that.dateOfViolation);
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
    return "MovingViolation{" + "type=" + type + ", dateOfViolation=" + dateOfViolation + '}';
  }
}
