package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.driver.register.DriverToRegister;
import edu.neu.ccs.cs5004.vehicle.register.VehicleToRegister;
import org.junit.Before;
import org.junit.Test;

public class ObjectToRegisterTest {
  private VehicleToRegister vehicleToRegister;
  private DriverToRegister driverToRegister;
  private TestUtilities testUtilities;
  private ObjectToRegister objectToRegister;
  private ObjectToRegister objectToRegister2;

  @Before
  public void setUp() throws Exception {
    testUtilities = new TestUtilities();
    vehicleToRegister = testUtilities.creatVehicleToRegister();
    driverToRegister = testUtilities.creatDriverToRegister();
    objectToRegister = new ObjectToRegister(vehicleToRegister, driverToRegister);
    objectToRegister2 = new ObjectToRegister(vehicleToRegister, driverToRegister);
  }

  @Test
  public void getVehicleToRegister() {
    assertEquals(vehicleToRegister, objectToRegister.getVehicleToRegister());
  }

  @Test
  public void getDriverToRegister() {
    assertEquals(driverToRegister, objectToRegister.getDriverToRegister());
  }


  @Test
  public void testHashCode() {
    assertNotNull(objectToRegister.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(objectToRegister.equals(objectToRegister2));
    assertTrue(objectToRegister.equals(objectToRegister));
    assertFalse(objectToRegister.equals(vehicleToRegister));
  }

  @Test
  public void testToString() {
    assertEquals("ObjectToRegister{vehicleToRegister=VehicleToRegister{vehicleInformation=VehicleInformation{maker='VW', model='Golf', year=2016, owner=Driver{firstName='A', lastName='B', birthday=1992-02-12}}, vehicleHistory=VehicleHistory{movingViolations=[MovingViolation{type=DrivingUnderInfluence, dateOfViolation=2019-03-01}], nonMovingViolations=[NonMovingViolation{type=ParkingViolation, dateOfViolation=2019-04-01}], crashes=[Crash{dateOfCrash=2019-01-02, offendingDriver=Driver{firstName='A', lastName='B', birthday=1992-02-12}, crashType=crashWithoutBodilyInjuriess}]}, vehicleInsuranceInformation=VehicleInsuranceInformation{owner=Driver{firstName='C', lastName='D', birthday=1993-02-12}, coveredDrivers=[], expirationDate=2020-01-02}}, driverToRegister=DriverToRegister{driverHistory=DriverHistory{movingViolations=[MovingViolation{type=DrivingUnderInfluence, dateOfViolation=2019-03-01}], nonMovingViolations=[NonMovingViolation{type=ParkingViolation, dateOfViolation=2019-04-01}]}, driver=Driver{firstName='A', lastName='B', birthday=1992-02-12}, license=License{licenseNumber='123456WA', driver=Driver{firstName='A', lastName='B', birthday=1992-02-12}, driverAddress='400 Boren Ave', issuanceCountry='US', issuanceState='WA', issuanceDate=2016-01-23, expirationDate=2022-01-23}}}", objectToRegister.toString());
  }
}