package edu.neu.ccs.cs5004.vehicle.register;

import java.util.Objects;

/**
 * This class represents a VehicleToRegister. A VehicleToRegister has a driverHistory,
 * vehicle information and InsuranceInformation
 */
public class VehicleToRegister implements IVehicleToRegister{
  private VehicleInformation vehicleInformation;
  private VehicleHistory vehicleHistory;
  private VehicleInsuranceInformation vehicleInsuranceInformation;

  /**
   * construct a ehicleToRegister has a driverHistory, vehicle information and InsuranceInformation.
   *
   * @param vehicleInformation the vehicleInformation of VehicleToRegister
   * @param vehicleHistory the vechile history of VehicleToRegister
   * @param vehicleInsuranceInformation the insurance information of VehicleToRegister
   */
  public VehicleToRegister(VehicleInformation vehicleInformation,
      VehicleHistory vehicleHistory,
      VehicleInsuranceInformation vehicleInsuranceInformation) {
    this.vehicleInformation = vehicleInformation;
    this.vehicleHistory = vehicleHistory;
    this.vehicleInsuranceInformation = vehicleInsuranceInformation;
  }

  /**
   * return the driver VehicleInformation.
   *
   * @return the driver VehicleInformation
   */
  public VehicleInformation getVehicleInformation() {
    return vehicleInformation;
  }

  /**
   * return the driver history.
   *
   * @return the driver history
   */
  public VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }

  /**
   * return the driver vehicle insurance information.
   *
   * @return the driver vehicleInsuranceInformation
   */
  public VehicleInsuranceInformation getVehicleInsuranceInformation() {
    return vehicleInsuranceInformation;
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
    if (!(object instanceof VehicleToRegister)) {
      return false;
    }
    VehicleToRegister that = (VehicleToRegister) object;
    return vehicleInformation.equals(that.vehicleInformation)
        && vehicleHistory.equals(that.vehicleHistory)
        && vehicleInsuranceInformation.equals(that.vehicleInsuranceInformation);
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(vehicleInformation, vehicleHistory, vehicleInsuranceInformation);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "VehicleToRegister{"
        + "vehicleInformation=" + vehicleInformation + ", vehicleHistory=" + vehicleHistory
        + ", vehicleInsuranceInformation=" + vehicleInsuranceInformation + '}';
  }
}
