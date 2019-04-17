package edu.neu.ccs.cs5004.driver.register;

import java.util.Objects;

/**
 * This class represents a DriverToRegister. A Driver has a driverHistory, driver information and
 * license
 */
public class DriverToRegister implements IDriverToRegister {

  public DriverHistory driverHistory;
  public Driver driver;
  public License license;

  /**
   * Construct a driver to register.
   *
   * @param driverHistory the history of the driver to register
   * @param driver the information of the driver to register
   * @param license the license information of the driver to register
   */
  public DriverToRegister(DriverHistory driverHistory, Driver driver,
      License license) {
    this.driverHistory = driverHistory;
    this.driver = driver;
    this.license = license;
  }

  /**
   * return the driver history.
   *
   * @return the driver history
   */
  public DriverHistory getDriverHistory() {
    return driverHistory;
  }

  /**
   * return the driver information.
   *
   * @return the driver
   */
  public Driver getDriver() {
    return driver;
  }

  /**
   * return the driver license.
   *
   * @return the license
   */
  public License getLicense() {
    return license;
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
    if (!(object instanceof DriverToRegister)) {
      return false;
    }
    DriverToRegister that = (DriverToRegister) object;
    return driverHistory.equals(that.driverHistory) && driver.equals(that.driver)
        && license.equals(that.license);
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(driverHistory, driver, license);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "DriverToRegister{" + "driverHistory=" + driverHistory + ", driver=" + driver
        + ", license=" + license + '}';
  }
}
