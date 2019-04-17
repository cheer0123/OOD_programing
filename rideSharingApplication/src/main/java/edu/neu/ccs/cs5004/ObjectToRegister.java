package edu.neu.ccs.cs5004;

import edu.neu.ccs.cs5004.driver.register.DriverToRegister;
import edu.neu.ccs.cs5004.vehicle.register.VehicleToRegister;

import java.util.Objects;

/**
 * This class represents a ObjectToRegister.
 * A ObjectToRegister has a vehicleToRegister and a driverToRegister.
 */
public class ObjectToRegister {
  private VehicleToRegister vehicleToRegister;
  private DriverToRegister driverToRegister;

  /**
   * construct the object ready to register.
   *
   * @param vehicleToRegister the vehicle including all required information
   * @param driverToRegister  the driver including all required information
   */
  public ObjectToRegister(VehicleToRegister vehicleToRegister, DriverToRegister driverToRegister) {
    this.vehicleToRegister = vehicleToRegister;
    this.driverToRegister = driverToRegister;
  }

  /**
   * return the vehicleToRegister.
   *
   * @return the vehicleToRegister
   */
  public VehicleToRegister getVehicleToRegister() {
    return vehicleToRegister;
  }

  /**
   * return the driverToRegister.
   *
   * @return the driverToRegister
   */
  public DriverToRegister getDriverToRegister() {
    return driverToRegister;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof ObjectToRegister)) {
      return false;
    }
    ObjectToRegister that = (ObjectToRegister) object;
    return vehicleToRegister.equals(that.vehicleToRegister)
        && driverToRegister.equals(that.driverToRegister);
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(vehicleToRegister, driverToRegister);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "ObjectToRegister{"
        + "vehicleToRegister=" + vehicleToRegister
        + ", driverToRegister=" + driverToRegister
        + '}';
  }
}
