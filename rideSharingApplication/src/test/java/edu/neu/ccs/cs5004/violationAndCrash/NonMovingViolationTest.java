package edu.neu.ccs.cs5004.violationAndCrash;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation.NonMovingViolationType;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class NonMovingViolationTest {
  private NonMovingViolationType type;
  private LocalDate dateOfViolation;
  private NonMovingViolation nonMovingViolation;
  private NonMovingViolation nonMovingViolation2;

  @Before
  public void setUp() throws Exception {
    type = NonMovingViolationType.ParkingViolation;
    nonMovingViolation = new NonMovingViolation(type, LocalDate.of(2019,1,1));
    nonMovingViolation2 = new NonMovingViolation(type, LocalDate.of(2019,2,1));
  }
  @Test
  public void getType() {
    type = NonMovingViolationType.ParkingViolation;
    nonMovingViolation = new NonMovingViolation(type, LocalDate.of(2019,1,1));
    assertEquals(type, nonMovingViolation.getType());
  }

  @Test
  public void getDateOfViolation() {
    dateOfViolation = LocalDate.of(2019,1,1);
    assertEquals(dateOfViolation, nonMovingViolation.getDateOfViolation());
  }

  @Test
  public void testHashCode() {
    assertNotNull(nonMovingViolation.hashCode());
  }

  @Test
  public void testEquals() {
    assertFalse(nonMovingViolation.equals(nonMovingViolation2));
    assertFalse(nonMovingViolation.equals(type));
    assertTrue(nonMovingViolation.equals(nonMovingViolation));
  }

  @Test
  public void testToString() {
    assertEquals("NonMovingViolation{type=ParkingViolation, dateOfViolation=2019-01-01}", nonMovingViolation.toString());
  }
}