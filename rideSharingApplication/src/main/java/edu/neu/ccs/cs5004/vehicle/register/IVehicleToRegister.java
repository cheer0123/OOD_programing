package edu.neu.ccs.cs5004.vehicle.register;

/**
 * This class represents an Interface of a VehicleToRegister. A VehicleToRegister has a
 * driverHistory, vehicle information and InsuranceInformation
 */
public interface IVehicleToRegister {

  /**
   * return the driver VehicleInformation.
   *
   * @return the driver VehicleInformation
   */
  VehicleInformation getVehicleInformation();

  /**
   * return the driver history.
   *
   * @return the driver history
   */
  VehicleHistory getVehicleHistory();

  /**
   * return the driver vehicle insurance information.
   *
   * @return the driver vehicleInsuranceInformation
   */
  VehicleInsuranceInformation getVehicleInsuranceInformation();

}
