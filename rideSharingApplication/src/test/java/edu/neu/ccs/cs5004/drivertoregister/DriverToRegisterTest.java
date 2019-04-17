package edu.neu.ccs.cs5004.drivertoregister;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.driver.register.Driver;
import edu.neu.ccs.cs5004.driver.register.DriverHistory;
import edu.neu.ccs.cs5004.driver.register.DriverToRegister;
import edu.neu.ccs.cs5004.driver.register.License;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation.MovingViolationType;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation.NonMovingViolationType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class DriverToRegisterTest {

  private DriverHistory driverHistory;
  private Driver driver;
  private Driver driver1;
  private License license;
  private License license1;
  private MovingViolation movingViolation1;
  private NonMovingViolation nonMovingViolation1;
  private List<MovingViolation> movingViolations;
  private List<NonMovingViolation> nonMovingViolations;
  private DriverToRegister driverToRegister;
  private DriverToRegister driverToRegister2;
  private DriverToRegister driverToRegister3;
  private DriverToRegister driverToRegister4;

  @Before
  public void setUp() throws Exception {
    movingViolation1 = new MovingViolation(
      MovingViolationType.DrivingUnderInfluence, LocalDate.of(2019,3,1));
    movingViolations = new ArrayList<>();
    movingViolations.add(movingViolation1);

    nonMovingViolation1 = new NonMovingViolation(NonMovingViolationType.ParkingViolation,
        LocalDate.of(2019,4,1));
    nonMovingViolations = new ArrayList<>();
    nonMovingViolations.add(nonMovingViolation1);

    driverHistory = new DriverHistory(movingViolations, nonMovingViolations);

    driver = new Driver("A", "B", LocalDate.of(1992,02,12));
    driver1 = new Driver("B", "B", LocalDate.of(1992,02,12));

    license = new License("123456WA",driver, "400 Boren Ave",
        "US", "WA", LocalDate.of(2016, 1, 23),
        LocalDate.of(2022, 1, 23));
    license1 = new License("123456",driver, "400 Boren Ave",
        "US", "WA", LocalDate.of(2016, 1, 23),
        LocalDate.of(2022, 1, 23));
    driverToRegister = new DriverToRegister(driverHistory, driver, license);
    driverToRegister2 = new DriverToRegister(driverHistory, driver, license);
    driverToRegister3 = new DriverToRegister(driverHistory, driver, license1);
    driverToRegister4 = new DriverToRegister(driverHistory, driver1, license1);

  }

  @Test
  public void getDriverHistory() {
    assertEquals(driverHistory,driverToRegister.getDriverHistory());
  }

  @Test
  public void getDriver() {
    assertEquals(driver, driverToRegister.getDriver());
  }

  @Test
  public void getLicense() {
    assertEquals(license, driverToRegister.getLicense());
  }

  @Test
  public void testHashCode() {
    assertNotNull(driverToRegister.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(driverToRegister.equals(driverToRegister2));
    assertFalse(driverToRegister.equals(driver));
    assertTrue(driverToRegister.equals(driverToRegister));
    assertFalse(driverToRegister.equals(driverToRegister3));
    assertFalse(driverToRegister.equals(driverToRegister4));
  }


  @Test
  public void testToString() {
    assertEquals("DriverToRegister{driverHistory=DriverHistory{movingViolations="
        + "[MovingViolation{type=DrivingUnderInfluence, dateOfViolation=2019-03-01}], "
        + "nonMovingViolations=[NonMovingViolation{type=ParkingViolation, "
        + "dateOfViolation=2019-04-01}]}, driver=Driver{firstName='A', lastName='B', "
        + "birthday=1992-02-12}, license=License{licenseNumber='123456WA', "
        + "driver=Driver{firstName='A', lastName='B', birthday=1992-02-12}, "
        + "driverAddress='400 Boren Ave', issuanceCountry='US', issuanceState='WA', "
        + "issuanceDate=2016-01-23, expirationDate=2022-01-23}}", driverToRegister.toString());
  }
}