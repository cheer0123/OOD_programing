package edu.neu.ccs.cs5004.drivertoregister;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.driver.register.Driver;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {

  private Driver driver1;
  private Driver driver2;
  private Driver driver3;

  @Before
  public void setUp() throws Exception {
    driver1 = new Driver("A", "B", LocalDate.of(1992,02,12));
    driver2 = new Driver("A", "B", LocalDate.of(1992,02,12));
    driver3 = new Driver("B", "B", LocalDate.of(1992,02,12));
  }

  @Test
  public void getFirstName() {
    assertEquals("A", driver1.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("B", driver1.getLastName());
  }

  @Test
  public void getBirthday() {
    assertEquals(LocalDate.of(1992,02,12), driver1.getBirthday());
  }

  @Test
  public void testHashCode() {
    assertNotNull(driver1.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(driver1.equals(driver2));
    assertFalse(driver1.equals(driver3));
  }


  @Test
  public void testToString() {
    assertEquals("Driver{firstName='A', lastName='B', birthday=1992-02-12}", driver1.toString());
  }
}