package edu.neu.ccs.cs5004.violation.crash;

import edu.neu.ccs.cs5004.driver.register.Driver;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class represents a Crash. A crash has a crashType, offendingDriver and dateOfCrash.
 */
public class Crash {

  protected LocalDate dateOfCrash;
  protected Driver offendingDriver;
  private CrashType crashType;

  /**
   *Including all crash types.
   */
  public static enum CrashType {
    fenderBender,  crashWithoutBodilyInjuriess,crashBodilyInjuriess
  }

  /**
   * construct a crash that has a crashType, offendingDriver and dateOfCrash.
   *
   * @param dateOfCrash the date of crash
   * @param offendingDriver the  offending driver in the crash
   * @param crashType the rash type
   */
  public Crash(LocalDate dateOfCrash, Driver offendingDriver, CrashType crashType) {
    this.dateOfCrash = dateOfCrash;
    this.offendingDriver = offendingDriver;
    this.crashType = crashType;
  }

  /**
   * return the date of crash.
   *
   * @return the date of crash
   */
  public LocalDate getDateOfCrash() {
    return dateOfCrash;
  }

  /**
   * return the offendingDriver of crash.
   *
   * @return the offendingDriver of crash
   */
  public Driver getOffendingDriver() {
    return offendingDriver;
  }

  /**
   * return the crashType of crash.
   *
   * @return the crashType of crash
   */
  public CrashType getCrashType() {
    return crashType;
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
    if (!(object instanceof Crash)) {
      return false;
    }
    Crash crash = (Crash) object;
    return dateOfCrash.equals(crash.dateOfCrash)
        && offendingDriver.equals(crash.offendingDriver)
        && crashType == crash.crashType;
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(dateOfCrash, offendingDriver, crashType);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "Crash{" + "dateOfCrash=" + dateOfCrash + ", offendingDriver=" + offendingDriver
        + ", crashType=" + crashType + '}';
  }
}
