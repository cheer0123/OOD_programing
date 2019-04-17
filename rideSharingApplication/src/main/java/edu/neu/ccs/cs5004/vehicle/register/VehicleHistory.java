package edu.neu.ccs.cs5004.vehicle.register;

import edu.neu.ccs.cs5004.violation.crash.Crash;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation;

import java.util.List;
import java.util.Objects;

/**
 * This class represents a VehicleHistory. A vehicle has a list of movingViolations and a list of
 * nonMovingViolations and a list of crashes
 */
public class VehicleHistory {

  private List<MovingViolation> movingViolations;
  private List<NonMovingViolation> nonMovingViolations;
  private List<Crash> crashes;

  /**
   * construct a vehicle that has a list of movingViolations and a list of
   * nonMovingViolations and a list of crashes.
   *
   * @param movingViolations the movingViolations of vehicle history
   * @param nonMovingViolations the Non movingViolations of vehicle history
   * @param crashes the crashes of vehicle history
   */
  public VehicleHistory(
      List<MovingViolation> movingViolations,
      List<NonMovingViolation> nonMovingViolations,
      List<Crash> crashes) {
    this.movingViolations = movingViolations;
    this.nonMovingViolations = nonMovingViolations;
    this.crashes = crashes;
  }

  /**
   * Add Crash to vehicle history.
   *
   * @param crash a class represent crash
   */
  public void addCrash(Crash crash) {
    crashes.add(crash);
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
   * return NonMovingViolations.
   *
   * @return NonmMvingViolations
   */
  public List<NonMovingViolation> getNonMovingViolations() {
    return nonMovingViolations;
  }


  /**
   * return crashes.
   *
   * @return crashes
   */
  public List<Crash> getCrashes() {
    return crashes;
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
    if (!(object instanceof VehicleHistory)) {
      return false;
    }
    VehicleHistory that = (VehicleHistory) object;
    return movingViolations.equals(that.movingViolations)
        && nonMovingViolations.equals(that.nonMovingViolations)
        && crashes.equals(that.crashes);
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(movingViolations, nonMovingViolations, crashes);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "VehicleHistory{"
        + "movingViolations=" + movingViolations
        + ", nonMovingViolations=" + nonMovingViolations + ", crashes=" + crashes + '}';
  }
}
