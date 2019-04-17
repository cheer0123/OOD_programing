package edu.neu.ccs.cs5004.vehicleToRegister;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.TestUtilities;
import edu.neu.ccs.cs5004.driver.register.Driver;

import edu.neu.ccs.cs5004.vehicle.register.VehicleHistory;
import edu.neu.ccs.cs5004.vehicle.register.VehicleInformation;
import edu.neu.ccs.cs5004.vehicle.register.VehicleInsuranceInformation;
import edu.neu.ccs.cs5004.vehicle.register.VehicleToRegister;
import edu.neu.ccs.cs5004.violation.crash.Crash;
import edu.neu.ccs.cs5004.violation.crash.Crash.CrashType;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation.MovingViolationType;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation.NonMovingViolationType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleToRegisterTest {

  private VehicleToRegister vehicleToRegister;
  private VehicleToRegister vehicleToRegister2;
  private VehicleInformation vehicleInformation;
  private Driver owner;
  private Driver driver;
  private List<Driver> coveredDrivers;
  private LocalDate expirationDate;
  private VehicleInsuranceInformation vehicleInsuranceInformation;

  private MovingViolation movingViolation;
  private NonMovingViolation nonMovingViolation;
  private Crash crash;
  private List<MovingViolation> movingViolations;
  private List<MovingViolation> movingViolations1;
  private List<NonMovingViolation> nonMovingViolations;
  private List<NonMovingViolation> nonMovingViolations1;
  private List<Crash> crashes;
  private List<Crash> crashes1;
  private VehicleHistory vehicleHistory;

  private Driver offendingDriver;


  @Before
  public void setUp() throws Exception {
    vehicleToRegister = TestUtilities.creatVehicleToRegister();
    vehicleToRegister2 = TestUtilities.creatVehicleToRegister();

    movingViolation = new MovingViolation(
        MovingViolationType.DrivingUnderInfluence, LocalDate.of(2019, 3, 1));
    movingViolations = new ArrayList<>();
    movingViolations1 = new ArrayList<>();
    movingViolations.add(movingViolation);

    nonMovingViolation = new NonMovingViolation(NonMovingViolationType.ParkingViolation,
        LocalDate.of(2019, 4, 1));

    nonMovingViolations = new ArrayList<>();
    nonMovingViolations1 = new ArrayList<>();
    nonMovingViolations.add(nonMovingViolation);

    crash = new Crash(LocalDate.of(2019, 1, 2), offendingDriver,
        CrashType.crashWithoutBodilyInjuriess);

    crashes = new ArrayList<>();
    crashes1 = new ArrayList<>();
    crashes.add(crash);

    vehicleHistory = new VehicleHistory(movingViolations, nonMovingViolations, crashes);

  }


  @Test
  public void getVehicleInformation() {
    driver = new Driver("A", "B", LocalDate.of(1992, 02, 12));
    vehicleInformation = new VehicleInformation("VW", "Golf", 2016, driver);
    assertEquals(vehicleInformation, vehicleToRegister.getVehicleInformation());
  }

  @Test
  public void getVehicleHistory() {
    assertEquals(TestUtilities.getVehicleHistory(),vehicleToRegister.getVehicleHistory());
  }

  @Test
  public void getVehicleInsuranceInformation() {
    owner = new Driver("C", "D", LocalDate.of(1993,02,12));
    coveredDrivers = new ArrayList<>();
    expirationDate = LocalDate.of(2020,1,2);
    vehicleInsuranceInformation = new VehicleInsuranceInformation(
        owner,coveredDrivers,expirationDate);
    assertEquals(vehicleInsuranceInformation, vehicleToRegister.getVehicleInsuranceInformation());
  }


  @Test
  public void testHashCode() {
    assertNotNull(vehicleToRegister.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(vehicleToRegister.equals(vehicleToRegister2));
    assertFalse(vehicleToRegister.equals(nonMovingViolation));
    assertTrue(vehicleToRegister.equals(vehicleToRegister));


  }

  @Test
  public void testToString() {
  assertEquals("VehicleToRegister{vehicleInformation=VehicleInformation{maker='VW', model='Golf', year=2016, owner=Driver{firstName='A', lastName='B', birthday=1992-02-12}}, vehicleHistory=VehicleHistory{movingViolations=[MovingViolation{type=DrivingUnderInfluence, dateOfViolation=2019-03-01}], nonMovingViolations=[NonMovingViolation{type=ParkingViolation, dateOfViolation=2019-04-01}], crashes=[Crash{dateOfCrash=2019-01-02, offendingDriver=Driver{firstName='A', lastName='B', birthday=1992-02-12}, crashType=crashWithoutBodilyInjuriess}]}, vehicleInsuranceInformation=VehicleInsuranceInformation{owner=Driver{firstName='C', lastName='D', birthday=1993-02-12}, coveredDrivers=[], expirationDate=2020-01-02}}",
      vehicleToRegister.toString());
  }
}