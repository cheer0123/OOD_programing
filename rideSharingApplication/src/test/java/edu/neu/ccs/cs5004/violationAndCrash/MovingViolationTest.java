package edu.neu.ccs.cs5004.violationAndCrash;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.violation.crash.MovingViolation;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation.MovingViolationType;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation;
import edu.neu.ccs.cs5004.violation.crash.NonMovingViolation.NonMovingViolationType;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class MovingViolationTest {
  private NonMovingViolation nonMovingViolation;
  private NonMovingViolationType nonMovingViolationType;
  private MovingViolationType type;
  private LocalDate dateOfViolation;
  private MovingViolation movingViolation;
  private MovingViolation movingViolation2;
  @Before
  public void setUp() throws Exception {
    type = MovingViolationType.DrivingUnderInfluence;
    movingViolation = new MovingViolation(type, LocalDate.of(2019,1,1));
    movingViolation2 = new MovingViolation(type, LocalDate.of(2019,1,1));
    nonMovingViolation = new NonMovingViolation(nonMovingViolationType, LocalDate.of(2019,1,1));
  }

  @Test
  public void getDateOfViolation() {
    dateOfViolation = LocalDate.of(2019,1,1);
    assertEquals(dateOfViolation, movingViolation.getDateOfViolation());
  }

  @Test
  public void getType() {
    MovingViolationType type = MovingViolationType.DrivingUnderInfluence;
    assertEquals(type, movingViolation.getType());
  }

  @Test
  public void testHashCode() {
    assertNotNull(movingViolation.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(movingViolation.equals(movingViolation2));
    assertFalse(movingViolation.equals(nonMovingViolation));
  }

  @Test
  public void testToString() {
    assertEquals("MovingViolation{type=DrivingUnderInfluence, dateOfViolation=2019-01-01}", movingViolation.toString());
  }
}