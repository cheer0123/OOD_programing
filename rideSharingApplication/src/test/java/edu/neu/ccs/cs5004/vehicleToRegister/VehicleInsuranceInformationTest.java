package edu.neu.ccs.cs5004.vehicleToRegister;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.driver.register.Driver;

import edu.neu.ccs.cs5004.vehicle.register.VehicleInsuranceInformation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleInsuranceInformationTest {
  private VehicleInsuranceInformation vehicleInsuranceInformation;
  private Driver owner;
  private Driver owner1;
  private List<Driver> coveredDrivers;
  private LocalDate expirationDate;
  private VehicleInsuranceInformation vehicleInsuranceInformation2;
  private VehicleInsuranceInformation vehicleInsuranceInformation1;

  @Before
  public void setUp() throws Exception {
    owner = new Driver("A", "B", LocalDate.of(1992,02,12));
    owner1 = new Driver("B", "B", LocalDate.of(1992,02,12));
    coveredDrivers = new ArrayList<>();
    expirationDate = LocalDate.of(2020,1,2);
    vehicleInsuranceInformation = new VehicleInsuranceInformation(owner,coveredDrivers,expirationDate);
    vehicleInsuranceInformation1 = new VehicleInsuranceInformation(owner,coveredDrivers,expirationDate);
    vehicleInsuranceInformation2 = new VehicleInsuranceInformation(owner1,coveredDrivers,expirationDate);
  }

  @Test
  public void getOwner() {
    assertEquals(owner, vehicleInsuranceInformation.getOwner());
  }

  @Test
  public void getCoveredDrivers() {
    assertEquals(coveredDrivers, vehicleInsuranceInformation.getCoveredDrivers());
  }

  @Test
  public void getExpirationDate() {
    assertEquals(expirationDate, vehicleInsuranceInformation.getExpirationDate());
  }

  @Test
  public void testHashCode() {
    assertNotNull(vehicleInsuranceInformation.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(vehicleInsuranceInformation.equals(vehicleInsuranceInformation1));
    assertFalse(vehicleInsuranceInformation.equals(vehicleInsuranceInformation2));
    assertFalse(vehicleInsuranceInformation.equals(owner));
    assertTrue(vehicleInsuranceInformation.equals(vehicleInsuranceInformation));
  }

  @Test
  public void testToString() {
    assertEquals("VehicleInsuranceInformation{owner=Driver{firstName='A', lastName='B', "
            + "birthday=1992-02-12}, coveredDrivers=[], expirationDate=2020-01-02}",
        vehicleInsuranceInformation.toString());
  }


}