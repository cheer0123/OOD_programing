package edu.neu.ccs.cs5004.driver.register;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class represents a License. A License has a licenseNumber, driver, driverAddress,
 * issuanceCountry, issuanceState, issuanceDate and expirationDate
 */
public class License {

  private String licenseNumber;
  private Driver driver;
  private String driverAddress;
  private String issuanceCountry;
  private String issuanceState;
  private LocalDate issuanceDate;
  private LocalDate expirationDate;


  /**
   * Construct a license including icenseNumber, driver, driverAddress, issuanceCountry,
   * issuanceState, issuanceDate and expirationDate.
   *
   * @param licenseNumber the license unique number
   * @param driver the driver including  a driver’s name and birthday
   * @param driverAddress the driver’s address
   * @param issuanceCountry the issuanceCountry
   * @param issuanceState the issuanceState
   * @param issuanceDate the issuanceDate
   * @param expirationDate the expirationDate
   */
  public License(String licenseNumber, Driver driver, String driverAddress, String issuanceCountry,
      String issuanceState, LocalDate issuanceDate, LocalDate expirationDate) {
    this.licenseNumber = licenseNumber;
    this.driverAddress = driverAddress;
    this.issuanceCountry = issuanceCountry;
    this.issuanceState = issuanceState;
    this.expirationDate = expirationDate;
    this.issuanceDate = issuanceDate;
    this.driver = driver;
  }

  /**
   * return the license number.
   *
   * @return the license number
   */
  public String getLicenseNumber() {
    return licenseNumber;
  }

  /**
   * return the driver including  a driver’s name and birthday.
   *
   * @return the driver including  a driver’s name and birthday
   */
  public Driver getDriver() {
    return driver;
  }

  /**
   * return the driver's address.
   *
   * @return the driver's address
   */
  public String getDriverAddress() {
    return driverAddress;
  }

  /**
   * return the issuanceDate.
   *
   * @return the issuanceDate
   */
  public LocalDate getIssuanceDate() {
    return issuanceDate;
  }

  /**
   * return the issuanceCountry.
   *
   * @return the issuanceCountry
   */
  public String getIssuanceCountry() {
    return issuanceCountry;
  }

  /**
   * return the issuanceState.
   *
   * @return the issuanceState
   */
  public String getIssuanceState() {
    return issuanceState;
  }

  /**
   * return the expirationDate.
   *
   * @return the expirationDate
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
    if (!(object instanceof License)) {
      return false;
    }
    License license = (License) object;
    return licenseNumber.equals(license.licenseNumber) && driver.equals(license.driver)
        && driverAddress.equals(license.driverAddress)
        && issuanceCountry.equals(license.issuanceCountry)
        && issuanceState.equals(license.issuanceState)
        && issuanceDate.equals(license.issuanceDate)
        && expirationDate.equals(license.expirationDate);
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects
        .hash(licenseNumber, driver, driverAddress, issuanceCountry, issuanceState, issuanceDate,
            expirationDate);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "License{"
        + "licenseNumber='" + licenseNumber + '\'' + ", driver=" + driver
        + ", driverAddress='" + driverAddress + '\'' + ", issuanceCountry='"
        + issuanceCountry + '\'' + ", issuanceState='" + issuanceState + '\''
        + ", issuanceDate=" + issuanceDate + ", expirationDate=" + expirationDate + '}';
  }
}
