package edu.neu.ccs.cs5004.vehicle.register;

import edu.neu.ccs.cs5004.driver.register.Driver;

import java.util.Objects;

/**
 * This class represents basic information of vehicle, a vehicle has a maker, model, year and owner.
 */
public class VehicleInformation {
  private String maker;
  private String model;
  private int year;
  private Driver owner;

  /**
   * construct basic information of a vehicle has a maker, model, year, owner.
   *
   * @param maker the maker of vehicle
   * @param model the model of vehicle
   * @param year the year of vehicle
   * @param owner the owner of vehicle
   */
  public VehicleInformation(String maker, String model, int year,
      Driver owner) {
    this.maker = maker;
    this.model = model;
    this.year = year;
    this.owner = owner;
  }

  /**
   * return maker of vehicle.
   *
   * @return maker of vehicle
   */
  public String getMaker() {
    return maker;
  }

  /**
   * return model of vehicle.
   *
   * @return model of vehicle
   */
  public String getModel() {
    return model;
  }

  /**
   * return year of vehicle.
   *
   * @return year of vehicle
   */
  public int getYear() {
    return year;
  }

  /**
   * return owner of vehicle.
   *
   * @return owner of vehicle
   */
  public Driver getOwner() {
    return owner;
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
    if (!(object instanceof VehicleInformation)) {
      return false;
    }
    VehicleInformation that = (VehicleInformation) object;
    return year == that.year
        && Objects.equals(maker, that.maker)
        && Objects.equals(model, that.model)
        && Objects.equals(owner, that.owner);
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(maker, model, year, owner);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "VehicleInformation{" + "maker='" + maker + '\'' + ", model='" + model + '\''
        + ", year=" + year + ", owner=" + owner + '}';
  }
}
