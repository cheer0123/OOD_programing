package edu.neu.ccs.cs5004.drivertoregister;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.driver.register.Driver;
import edu.neu.ccs.cs5004.driver.register.License;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class LicenseTest {
  License license;
  License license1;
  License license2;
  License license3;
  License license4;
  Driver driver1;
  LocalDate issuseDate;
  LocalDate expirationDate;

  @Before
  public void setUp() throws Exception {
    driver1 = new Driver("A", "B", LocalDate.of(1992,02,12));
    issuseDate =  LocalDate.of(2016, 1, 23);
    expirationDate = LocalDate.of(2022, 1, 23);
    license = new License("123456WA",driver1, "400 Boren Ave",
        "US", "WA",issuseDate, expirationDate);
    license1 = new License("123456WA",driver1, "400 Boren Ave",
        "US", "WA",issuseDate, expirationDate);
    license2 = new License("123456WA",driver1, "400 Boren Ave",
        "CA", "WA",issuseDate, expirationDate);
    license3 = new License("123456",driver1, "400 Boren Ave",
        "US", "WA",issuseDate, expirationDate);
    license4 = new License("123456WA",driver1, "401 Boren Ave",
        "US", "WA",issuseDate, expirationDate);
  }

  @Test
  public void getIssuanceDate() {
    assertEquals(LocalDate.of(2016, 1, 23), license.getIssuanceDate());
  }

  @Test
  public void getLicenseNumber() {
    assertEquals("123456WA", license.getLicenseNumber());
  }

  @Test
  public void getDriver() {
    assertEquals(driver1, license.getDriver());
  }

  @Test
  public void getDriverAddress() {
    assertEquals("400 Boren Ave", license.getDriverAddress());
  }

  @Test
  public void getIssuanceCountry() {
    assertEquals("US", license.getIssuanceCountry());
  }

  @Test
  public void getIssuanceState() {
    assertEquals("WA", license.getIssuanceState());
  }

  @Test
  public void getExpirationDate() {
    assertEquals(LocalDate.of(2022, 1, 23), license.getExpirationDate());
  }

  @Test
  public void testHashCode() {
    assertNotNull(license.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(license1.equals(license));
    assertFalse(license.equals(driver1));
    assertFalse(license.equals(license2));
    assertFalse(license.equals(license3));
    assertFalse(license.equals(license4));
  }


  @Test
  public void testToString() {
    assertEquals("License{licenseNumber='123456WA', driver=Driver{firstName='A', "
        + "lastName='B', birthday=1992-02-12}, driverAddress='400 Boren Ave', issuanceCountry='US',"
        + " issuanceState='WA', issuanceDate=2016-01-23, expirationDate=2022-01-23}",
        license.toString());
  }
}