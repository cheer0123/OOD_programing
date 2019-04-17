package edu.neu.ccs.cs5004.violationAndCrash;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.violation.crash.Crash;
import edu.neu.ccs.cs5004.driver.register.Driver;
import edu.neu.ccs.cs5004.violation.crash.Crash.CrashType;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation.NonMovingViolationType;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class CrashTest {
  private NonMovingViolationType type;
  private NonMovingViolation nonMovingViolation;
  private Crash crash;
  private Crash crash1;
  private Crash crash2;
  private LocalDate date;
  private Driver offendingDriver;
  private CrashType crashType;

  @Before
  public void setUp() throws Exception {
    type = NonMovingViolationType.ParkingViolation;
    nonMovingViolation = new NonMovingViolation(type, LocalDate.of(2019,1,1));
    offendingDriver = new Driver("A", "B", LocalDate.of(1992,02,12));
    crashType = CrashType.crashBodilyInjuriess;
    crash = new Crash(LocalDate.of(2019,1,1), offendingDriver, crashType);
    crash1 = new Crash(LocalDate.of(2019,1,1), offendingDriver, crashType);
    crash2 = new Crash(LocalDate.of(2018,1,1), offendingDriver, crashType);
  }

  @Test
  public void getDateOfCrash() {
    date = LocalDate.of(2019,1,1);
    assertEquals(date, crash.getDateOfCrash());
  }

  @Test
  public void getoffendingDriver() {
    Driver offendingDriver = new Driver("A", "B", LocalDate.of(1992,02,12));
    assertEquals(offendingDriver, crash.getOffendingDriver());
  }

  @Test
  public void getcrashType() {
    crashType = CrashType.crashBodilyInjuriess;
    assertEquals(crashType, crash.getCrashType());
  }

  @Test
  public void testHashCode() {
    assertNotNull(crash.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(crash.equals(crash1));
    assertFalse(crash.equals(crash2));
    assertFalse(crash.equals(nonMovingViolation));
  }

  @Test
  public void testToString() {
    assertEquals("Crash{dateOfCrash=2019-01-01, offendingDriver=Driver{firstName='A', "
        + "lastName='B', birthday=1992-02-12}, crashType=crashBodilyInjuriess}", crash.toString());
  }
}