package edu.neu.ccs.cs5004.drivertoregister;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.driver.register.DriverHistory;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation;

import edu.neu.ccs.cs5004.violation.crash.MovingViolation.MovingViolationType;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation;

import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation.NonMovingViolationType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class DriverHistoryTest {
  private MovingViolation movingViolation1;
  private MovingViolation movingViolation2;
  private NonMovingViolation nonMovingViolation1;
  private NonMovingViolation nonMovingViolation2;
  private List<MovingViolation> movingViolations;
  private List<NonMovingViolation> nonMovingViolations;
  private DriverHistory driverHistory;
  private DriverHistory driverHistory2;
  private DriverHistory driverHistory3;
  private DriverHistory driverHistory4;
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
    driverHistory2 = new DriverHistory(movingViolations, nonMovingViolations);
    driverHistory3 = new DriverHistory(movingViolations, nonMovingViolations);
    driverHistory4 = new DriverHistory(movingViolations, nonMovingViolations);
  }

  @Test
  public void addMovingViolation() {
    nonMovingViolation2 = new NonMovingViolation(NonMovingViolationType.VehicleProblems,
        LocalDate.of(2017,4,1));
    List<MovingViolation> movingViolations = new ArrayList<>();
    driverHistory.addMovingViolation(movingViolation2);
    assertTrue(driverHistory.getMovingViolations().contains(movingViolation2));
  }

  @Test
  public void addNonMovingViolation() {
    movingViolation2 = new MovingViolation(
        MovingViolationType.Speeding, LocalDate.of(2018,3,1));
    nonMovingViolations = new ArrayList<>();
    driverHistory.addNonMovingViolation(nonMovingViolation2);
    assertTrue(driverHistory.getNonMovingViolations().contains(nonMovingViolation2));
  }

  @Test
  public void getMovingViolations() {
    assertEquals(movingViolations, driverHistory.getMovingViolations());
  }

  @Test
  public void getNonMovingViolations() {
    assertEquals(nonMovingViolations, driverHistory.getNonMovingViolations());
  }

  @Test
  public void testHashCode() {
    assertNotNull(driverHistory.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(driverHistory.equals(driverHistory2));
    assertTrue(driverHistory.equals(driverHistory));
    assertFalse(driverHistory.equals(movingViolation1));
  }


  @Test
  public void testToString() {
    assertEquals("DriverHistory{movingViolations=[MovingViolation{type="
        + "DrivingUnderInfluence, dateOfViolation=2019-03-01}], nonMovingViolations="
        + "[NonMovingViolation{type=ParkingViolation, dateOfViolation=2019-04-01}]}",
        driverHistory.toString());
  }
}