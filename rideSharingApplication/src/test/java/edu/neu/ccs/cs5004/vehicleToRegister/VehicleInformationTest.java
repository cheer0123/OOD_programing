package edu.neu.ccs.cs5004.vehicleToRegister;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.driver.register.Driver;
import edu.neu.ccs.cs5004.vehicle.register.VehicleInformation;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class VehicleInformationTest {
  private VehicleInformation vehicleInformation;
  private VehicleInformation vehicleInformation2;
  private VehicleInformation vehicleInformation1;
  private VehicleInformation vehicleInformation3;
  private VehicleInformation vehicleInformation4;
  Driver driver;


  @Before
  public void setUp() throws Exception {
    driver = new Driver("A", "B", LocalDate.of(1992,02,12));
    vehicleInformation = new VehicleInformation("VW", "Golf", 2016, driver);
    vehicleInformation1 = new VehicleInformation("WWW", "Golf", 2016, driver);

    vehicleInformation2 = new VehicleInformation("VW", "Golf", 2016, driver);
    vehicleInformation3 = new VehicleInformation("VW", "Golf", 2017, driver);
    vehicleInformation4 = new VehicleInformation("VW", "A", 2016, driver);
  }

  @Test
  public void getMaker() {
    assertEquals("VW", vehicleInformation.getMaker());
  }

  @Test
  public void getModel() {
    assertEquals("Golf", vehicleInformation.getModel());
  }

  @Test
  public void getYear() {
    assertEquals(2016, vehicleInformation.getYear());
  }

  @Test
  public void getOwner() {
    assertEquals(driver, vehicleInformation.getOwner());
  }

  @Test
  public void testHashCode() {
    assertNotNull(vehicleInformation.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(vehicleInformation.equals(vehicleInformation2));
    assertFalse(vehicleInformation.equals(vehicleInformation1));
    assertTrue(vehicleInformation.equals(vehicleInformation));
    assertFalse(vehicleInformation.equals(driver));
    assertFalse(vehicleInformation.equals(vehicleInformation3));
    assertFalse(vehicleInformation.equals(vehicleInformation4));
    assertFalse(vehicleInformation.equals(vehicleInformation1));
  }

  @Test
  public void testToString() {
    assertEquals("VehicleInformation{maker='VW', model='Golf', year=2016, "
        + "owner=Driver{firstName='A', lastName='B', birthday=1992-02-12}}",
        vehicleInformation.toString());
  }
}