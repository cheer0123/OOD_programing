package edu.neu.ccs.cs5004.vehicleToRegister;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.driver.register.Driver;
import edu.neu.ccs.cs5004.vehicle.register.VehicleHistory;
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

public class VehicleHistoryTest  {
  private MovingViolation movingViolation;
  private NonMovingViolation nonMovingViolation;

  private Crash crash;
  private Crash crash1;
  private List<MovingViolation> movingViolations;
  private List<MovingViolation> movingViolations1;
  private List<NonMovingViolation> nonMovingViolations;
  private List<NonMovingViolation> nonMovingViolations1;
  private List<Crash> crashes;
  private List<Crash> crashes1;
  private VehicleHistory vehicleHistory;
  private Driver offendingDriver;
  private VehicleHistory vehicleHistory2;
  private VehicleHistory vehicleHistory1;
  private VehicleHistory vehicleHistory3;
  private VehicleHistory vehicleHistory4;
  private VehicleHistory vehicleHistory5;

  @Before
  public void setUp() throws Exception {
    offendingDriver = new Driver("A", "B", LocalDate.of(1992,02,12));
    movingViolation = new MovingViolation(
        MovingViolationType.DrivingUnderInfluence, LocalDate.of(2019,3,1));
    movingViolations = new ArrayList<>();
    movingViolations1 = new ArrayList<>();

    nonMovingViolation = new NonMovingViolation(NonMovingViolationType.ParkingViolation,
        LocalDate.of(2019,4,1));

    nonMovingViolations = new ArrayList<>();
    nonMovingViolations1 = new ArrayList<>();
    nonMovingViolations.add(nonMovingViolation);

    crash = new Crash(LocalDate.of(2019,1,2), offendingDriver,
        CrashType.crashWithoutBodilyInjuriess);
    crash1 = new Crash(LocalDate.of(2018,1,2), offendingDriver,
        CrashType.crashWithoutBodilyInjuriess);
    crashes = new ArrayList<>();
    crashes1 = new ArrayList<>();
    crashes1.add(crash1);


    vehicleHistory = new VehicleHistory(movingViolations, nonMovingViolations, crashes);
    vehicleHistory1 = new VehicleHistory(movingViolations, nonMovingViolations, crashes);
    vehicleHistory1.addCrash(crash1);
    vehicleHistory2 = new VehicleHistory(movingViolations, nonMovingViolations, crashes);
    vehicleHistory3 = new VehicleHistory(movingViolations1, nonMovingViolations, crashes);
    vehicleHistory4 = new VehicleHistory(movingViolations, nonMovingViolations1, crashes);
    vehicleHistory5 = new VehicleHistory(movingViolations, nonMovingViolations, crashes1);
  }

  @Test
  public void addCrash() {
    vehicleHistory.addCrash(crash);
    assertTrue(vehicleHistory.getCrashes().contains(crash));

  }

  @Test
  public void addMovingViolation() {
    vehicleHistory.addMovingViolation(movingViolation);
    assertTrue(vehicleHistory.getMovingViolations().contains(movingViolation));

  }

  @Test
  public void addNonMovingViolation() {
    vehicleHistory.addNonMovingViolation(nonMovingViolation);
    assertTrue(vehicleHistory.getNonMovingViolations().contains(nonMovingViolation));
  }

  @Test
  public void getMovingViolations() {
    assertEquals(movingViolations, vehicleHistory.getMovingViolations());
  }

  @Test
  public void getNonMovingViolations() {
    assertEquals(nonMovingViolations, vehicleHistory.getNonMovingViolations());
  }

  @Test
  public void getCrashes() {
    assertEquals(crashes, vehicleHistory.getCrashes());
  }

  @Test
  public void testHashCode() {
    assertNotNull(crashes.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(vehicleHistory.equals(vehicleHistory));
    assertTrue(vehicleHistory.equals(vehicleHistory2));
    assertFalse(vehicleHistory.equals(offendingDriver));
    assertTrue(vehicleHistory.equals(vehicleHistory3));
    assertFalse(vehicleHistory.equals(vehicleHistory4));
  }


  @Test
  public void testToString() {
    assertEquals("VehicleHistory{movingViolations=[], nonMovingViolations=[NonMovingViolation{type=ParkingViolation, dateOfViolation=2019-04-01}], crashes=[Crash{dateOfCrash=2018-01-02, offendingDriver=Driver{firstName='A', lastName='B', birthday=1992-02-12}, crashType=crashWithoutBodilyInjuriess}]}"
                , vehicleHistory.toString());
  }
}