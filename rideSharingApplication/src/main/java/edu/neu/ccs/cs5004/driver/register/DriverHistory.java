package edu.neu.ccs.cs5004.driver.register;

import edu.neu.ccs.cs5004.violation.crash.MovingViolation;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation;

import java.util.List;
import java.util.Objects;

/**
 * This class represents a DriverHistory. A Driver has a list of movingViolations and a list of
 * nonMovingViolations
 */
public class DriverHistory {

  private List<MovingViolation> movingViolations;
  private List<NonMovingViolation> nonMovingViolations;

  /**
   * Construct a has a list of movingViolations and a list of nonMovingViolations.
   *
   * @param movingViolations a list of movingViolations
   * @param nonMovingViolations a list of nonMovingViolations
   */
  public DriverHistory(
      List<MovingViolation> movingViolations,
      List<NonMovingViolation> nonMovingViolations) {
    this.movingViolations = movingViolations;
    this.nonMovingViolations = nonMovingViolations;
  }

  /**
   * Add MovingViolation to vehicle history.
   *
   * @param movingViolation a class represent MovingViolation
   */
  public void addMovingViolation(MovingViolation movingViolation) {
    movingViolations.add(movingViolation);
  }

  /**
   * Add NonMovingViolation to vehicle history.
   *
   * @param nonMovingViolation a class represent NonMovingViolation
   */
  public void addNonMovingViolation(NonMovingViolation nonMovingViolation) {
    nonMovingViolations.add(nonMovingViolation);
  }

  /**
   * return movingViolations.
   *
   * @return movingViolations
   */
  public List<MovingViolation> getMovingViolations() {
    return movingViolations;
  }

  /**
   * return nonMovingViolations.
   *
   * @return NonMovingViolations
   */
  public List<NonMovingViolation> getNonMovingViolations() {
    return nonMovingViolations;
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
    if (!(object instanceof DriverHistory)) {
      return false;
    }
    DriverHistory that = (DriverHistory) object;
    return Objects.equals(movingViolations, that.movingViolations)
        && Objects.equals(nonMovingViolations, that.nonMovingViolations);
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(movingViolations, nonMovingViolations);
  }


  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "DriverHistory{" + "movingViolations=" + movingViolations
        + ", nonMovingViolations=" + nonMovingViolations + '}';
  }
}
