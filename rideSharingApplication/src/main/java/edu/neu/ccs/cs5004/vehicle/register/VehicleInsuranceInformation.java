package edu.neu.ccs.cs5004.vehicle.register;

import edu.neu.ccs.cs5004.driver.register.Driver;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * This class represents basic information of vehicle insurance, a vehicle insurance has
 * a vehicle owner, expirationDate and coveredDrivers.
 */
public class VehicleInsuranceInformation {
  private Driver owner;
  private List<Driver> coveredDrivers;
  private LocalDate expirationDate;

  /**
   * Construct a information of vehicle insurance including a vehicle owner,
   * expirationDate and coveredDrivers.
   *
   * @param owner the owner of vehicle insurance
   * @param coveredDrivers the coveredDrivers of vehicle insurance
   * @param expirationDate the expirationDate of vehicle insurance
   */
  public VehicleInsuranceInformation(Driver owner,
      List<Driver> coveredDrivers, LocalDate expirationDate) {
    this.owner = owner;
    this.coveredDrivers = coveredDrivers;
    this.expirationDate = expirationDate;
  }

  /**
   * return the owner of vehicle insurance.
   *
   * @return the owner of vehicle insurance
   */
  public Driver getOwner() {
    return owner;
  }

  /**
   * return the coveredDrivers of vehicle insurance.
   *
   * @return the coveredDrivers of vehicle insurance
   */
  public List<Driver> getCoveredDrivers() {
    return coveredDrivers;
  }

  /**
   * return the expirationDate of vehicle insurance.
   *
   * @return the expirationDate of vehicle insurance
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
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
    if (!(object instanceof VehicleInsuranceInformation)) {
      return false;
    }
    VehicleInsuranceInformation that = (VehicleInsuranceInformation) object;
    return Objects.equals(owner, that.owner)
        && Objects.equals(coveredDrivers, that.coveredDrivers)
        && Objects.equals(expirationDate, that.expirationDate);
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(owner, coveredDrivers, expirationDate);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "VehicleInsuranceInformation{"
        + "owner=" + owner + ", coveredDrivers=" + coveredDrivers + ", expirationDate="
        + expirationDate + '}';
  }
}
