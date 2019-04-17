package edu.neu.ccs.cs5004.driver.register;

/**
 * This class represents interface of a DriverToRegister. A Driver has a driverHistory, driver
 * information and license
 */
public interface IDriverToRegister {
  /**
   * return the driver history.
   *
   * @return the driver history
   */
  DriverHistory getDriverHistory();

  /**
   * return the driver information.
   *
   * @return the driver
   */
  Driver getDriver();

  /**
   * return the driver license.
   *
   * @return the license
   */
  License getLicense();
}
