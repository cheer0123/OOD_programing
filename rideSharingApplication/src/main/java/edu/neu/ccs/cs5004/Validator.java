package edu.neu.ccs.cs5004;

import edu.neu.ccs.cs5004.driver.register.Driver;
import edu.neu.ccs.cs5004.driver.register.DriverHistory;
import edu.neu.ccs.cs5004.driver.register.License;
import edu.neu.ccs.cs5004.vehicle.register.VehicleInformation;
import edu.neu.ccs.cs5004.vehicle.register.VehicleInsuranceInformation;
import edu.neu.ccs.cs5004.violation.crash.Crash;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation.MovingViolationType;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * This class represents a Validator.
 * A validator can decide whether the object can be add to pool.
 */
public class Validator {
  private ObjectToRegister objectToRegister;
  private LocalDate now = LocalDate.now();

  /**
   * Construct a validator including an object to validate.
   *
   * @param objectToRegister the object to validate
   */
  public Validator(ObjectToRegister objectToRegister) {
    this.objectToRegister = objectToRegister;
  }

  /**
   * Contains validateDriverLicense, validateDriverHistory,  validateVehicleHistory,
   * validateVehicleand and validateInsurance. Checl all information and return a boolean represent
   * whether the object can be add to pool or not.
   *
   * @return a boolean represent whether the object can be add to pool or not.
   */
  public Boolean validation() {
    if (validateDriverLicense() && validateDriverHistory()
        && validateInsurance() && validateVehicle() && validateVehicleHistory()) {
      return true;
    }
    return false;
  }

  /**
   * return a boolean represent whether the information of DriverLicense fulfill the requirement.
   *
   * @return a boolean represent whether the information of DriverLicense fulfill the requirement
   */
  private Boolean validateDriverLicense() {
    Driver driver = objectToRegister.getDriverToRegister().getDriver();
    License license = objectToRegister.getDriverToRegister().getLicense();
    LocalDate today = LocalDate.now();
    Period p1 = Period.between(driver.getBirthday(), today);

    if (p1.getYears() < 21) {
      return false;
    }
    if (!driver.getFirstName().equals(license.getDriver().getFirstName())
        || !driver.getLastName().equals(license.getDriver().getLastName())
        || !driver.getBirthday().isEqual(license.getDriver().getBirthday())
        || !"US".equals(license.getIssuanceCountry())
        || license.getIssuanceDate().isAfter(LocalDate.now().minusMonths(6))) {
      return false;
    }

    if (license.getExpirationDate().isBefore(now)) {
      return false;
    }
    return true;
  }

  /**
   * return a boolean represent whether the information of DriverHistory fulfill the requirement.
   *
   * @return a boolean represent whether the information of DriverHistory fulfill the requirement
   */
  private Boolean validateDriverHistory() {
    DriverHistory history = objectToRegister.getDriverToRegister().getDriverHistory();
    List<MovingViolation> violationList = ((DriverHistory) history).getMovingViolations();
    if (violationList.isEmpty()) {
      return true;
    }

    for (MovingViolation mv: violationList) {
      MovingViolationType violationType = mv.getType();
      if (violationType == MovingViolationType.RecklessDriving
          || violationType ==  MovingViolationType.DrivingUnderInfluence
          || violationType ==  MovingViolationType.Speeding
          || violationType ==  MovingViolationType.DrivingWithoutValidLicenseInsurance) {
        return false;
      }
    }
    return true;
  }

  /**
   * return a boolean represent whether the information of VehicleHistory fulfill the requirement.
   *
   * @return a boolean represent whether the information of VehicleHistory fulfill the requirement
   */
  private Boolean validateVehicleHistory() {
    List<MovingViolation> violationList =
        objectToRegister.getVehicleToRegister().getVehicleHistory().getMovingViolations();
    if (!violationList.isEmpty()) {
      for (MovingViolation movingViolation : violationList) {
        if (movingViolation.getDateOfViolation().isAfter(now.minusMonths(6))) {
          return false;
        }
      }
    }

    List<Crash> crashList =
        objectToRegister.getVehicleToRegister().getVehicleHistory().getCrashes();
    if (!crashList.isEmpty()) {
      for (Crash crash : crashList) {
        if (crash.getDateOfCrash().isAfter(now.minusMonths(6))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * return a boolean represent whether the information of Vehicle fulfill the requirement.
   *
   * @return a boolean represent whether the information of Vehicle fulfill the requirement
   */
  private Boolean validateVehicle() {
    if (objectToRegister.getVehicleToRegister().getVehicleInformation().getYear()
        <= now.minusYears(20).getYear()) {
      return false;
    }
    return true;
  }

  /**
   * return a boolean represent whether the information of Insurance fulfill the requirement.
   *
   * @return a boolean represent whether the information of Insurance fulfill the requirement
   */
  private Boolean validateInsurance() {
    VehicleInformation vehicle = objectToRegister.getVehicleToRegister().getVehicleInformation();
    VehicleInsuranceInformation insurance =
        objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation();

    if (!vehicle.getOwner().equals(objectToRegister.getDriverToRegister().getDriver())) {
      for (Driver driver: insurance.getCoveredDrivers()) {
        if (driver.equals(vehicle.getOwner())) {
          continue;
        }
        return false;
      }
    }

    if (insurance.getExpirationDate().isBefore(now)) {
      return false;
    }
    return true;
  }

//  /**
//   * Return a boolean whether they are equal.
//   *
//   * @param object the object to compare
//   * @return a boolean whether they are equal
//   */
//  @Override
//  public boolean equals(Object object) {
//    if (object == null) {
//      return false;
//    }
//    if (this == object) {
//      return true;
//    }
//    if (!(object instanceof MovingViolation)) {
//      return false;
//    }
//    Validator validator = (Validator) object;
//    return objectToRegister.equals(validator.objectToRegister) && now.equals(validator.now);
//  }

//  /**
//   * return the hash code.
//   *
//   * @return the hash code
//   */
//  @Override
//  public int hashCode() {
//    return Objects.hash(objectToRegister, now);
//  }
//
//  /**
//   * return the string type.
//   *
//   * @return the string type
//   */
//  @Override
//  public String toString() {
//    return "Validator{" + "objectToRegister=" + objectToRegister + ", now=" + now + '}';
//  }
}
