package edu.neu.ccs.cs5004;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import edu.neu.ccs.cs5004.driver.register.Driver;
import edu.neu.ccs.cs5004.driver.register.DriverHistory;
import edu.neu.ccs.cs5004.driver.register.License;
import edu.neu.ccs.cs5004.vehicle.register.VehicleHistory;
import edu.neu.ccs.cs5004.vehicle.register.VehicleInformation;
import edu.neu.ccs.cs5004.vehicle.register.VehicleInsuranceInformation;
import edu.neu.ccs.cs5004.violation.crash.Crash;
import edu.neu.ccs.cs5004.violation.crash.Crash.CrashType;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation;
import edu.neu.ccs.cs5004.violation.crash.MovingViolation.MovingViolationType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;

public class validatorTest {
  private Validator validator;

  ObjectToRegister objectToRegister = new ObjectToRegister(TestUtilities.creatVehicleToRegister()
      , TestUtilities.creatDriverToRegister());

  @Before
  public void setUp() {
    validator = new Validator(objectToRegister);
  }


  @Test
  public void testValidatorWithViolations() {
    assertFalse(validator.validation());
  }

  @Test
  @PrepareForTest(License.class)
  public void testValidatorWithInvalidLicense() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(2011,2,2));
    assertFalse(validator.validation());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class})
  public void testValidatorPassed() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(1990,2,2));
    MemberModifier.field(VehicleInsuranceInformation.class, "owner").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(), new Driver("A", "B", LocalDate.of(1990,02,02)));
    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "movingViolations").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "crashes").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());
    assertTrue(validator.validation());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class})
  public void testValidatorInvalidInsurance() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(1990,2,2));
    MemberModifier.field(VehicleInsuranceInformation.class, "owner").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(), new Driver("A", "B", LocalDate.of(1990,02,02)));
    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "movingViolations").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "crashes").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());

    MemberModifier.field(VehicleInsuranceInformation.class, "expirationDate").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(),  LocalDate.of(2019,2,2));
    assertFalse(validator.validation());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class})
  public void testValidatorFailedWithCrash() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(1990,2,2));
    MemberModifier.field(VehicleInsuranceInformation.class, "owner").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(), new Driver("A", "B", LocalDate.of(1990,02,02)));
    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "movingViolations").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());

    List<Crash> crashList = new ArrayList<>();
    crashList.add(new Crash(LocalDate.of(2019,01,01),
            objectToRegister.getDriverToRegister().getDriver(), CrashType.fenderBender));

    MemberModifier.field(VehicleHistory.class, "crashes").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), crashList);

    assertFalse(validator.validation());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class,
      VehicleInformation.class})
  public void testValidatorFailedOldVehicle() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(1990,2,2));
    MemberModifier.field(VehicleInsuranceInformation.class, "owner").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(), new Driver("A", "B", LocalDate.of(1990,02,02)));
    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "movingViolations").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());

    MemberModifier.field(VehicleInformation.class, "year").
        set(objectToRegister.getVehicleToRegister().getVehicleInformation(), 1991);

    assertFalse(validator.validation());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class})
  public void testValidatorFailedWithViolationCheck() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(1990,2,2));
    MemberModifier.field(VehicleInsuranceInformation.class, "owner").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(), new Driver("A", "B", LocalDate.of(1990,02,02)));

    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), new ArrayList<>());

    List<MovingViolation> movingViolationList = new ArrayList<>();
    movingViolationList.add(new MovingViolation(
        MovingViolationType.DrivingWithoutValidLicenseInsurance, LocalDate.of(2019,01,01)));

    MemberModifier.field(VehicleHistory.class, "movingViolations").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), movingViolationList);

    assertFalse(validator.validation());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class})
  public void testValidatorPassedWithGoodDrivingHistory() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(1990,2,2));
    MemberModifier.field(VehicleInsuranceInformation.class, "owner").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(), new Driver("A", "B", LocalDate.of(1990,02,02)));

    List<MovingViolation> movingViolationList = new ArrayList<>();
    movingViolationList.add(new MovingViolation(
        MovingViolationType.DistractedDriving, LocalDate.of(2019,01,01)));

    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), movingViolationList);

    MemberModifier.field(VehicleHistory.class, "movingViolations").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "crashes").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());
    assertTrue(validator.validation());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class, License.class})
  public void testValidatorFailedOnLicenseWithWrongIssuanceCountry() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(1990,2,2));

    MemberModifier.field(License.class, "expirationDate").
        set(objectToRegister.getDriverToRegister().getLicense(), LocalDate.of(2029,2,2));

    MemberModifier.field(License.class, "issuanceCountry").
        set(objectToRegister.getDriverToRegister().getLicense(), "UK");

    MemberModifier.field(VehicleInsuranceInformation.class, "owner").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(), new Driver("A", "B", LocalDate.of(1990,02,02)));

    List<MovingViolation> movingViolationList = new ArrayList<>();
    movingViolationList.add(new MovingViolation(
        MovingViolationType.DistractedDriving, LocalDate.of(2019,01,01)));

    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), movingViolationList);

    MemberModifier.field(VehicleHistory.class, "movingViolations").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "crashes").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());
    assertFalse(validator.validation());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class, License.class})
  public void testValidatorFailedOnExpiredLicense() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(1990,2,2));

    MemberModifier.field(License.class, "expirationDate").
        set(objectToRegister.getDriverToRegister().getLicense(), LocalDate.of(2009,2,2));

    MemberModifier.field(VehicleInsuranceInformation.class, "owner").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(), new Driver("A", "B", LocalDate.of(1990,02,02)));

    List<MovingViolation> movingViolationList = new ArrayList<>();
    movingViolationList.add(new MovingViolation(
        MovingViolationType.DistractedDriving, LocalDate.of(2019,01,01)));

    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), movingViolationList);

    MemberModifier.field(VehicleHistory.class, "movingViolations").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "crashes").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());
    assertFalse(validator.validation());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class, License.class})
  public void testValidatorFailedOnLicenseWithInvalidIssuanceDate() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(1990,2,2));

    MemberModifier.field(License.class, "issuanceDate").
        set(objectToRegister.getDriverToRegister().getLicense(), LocalDate.of(2019,3,2));

    MemberModifier.field(VehicleInsuranceInformation.class, "owner").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(), new Driver("A", "B", LocalDate.of(1990,02,02)));

    List<MovingViolation> movingViolationList = new ArrayList<>();
    movingViolationList.add(new MovingViolation(
        MovingViolationType.DistractedDriving, LocalDate.of(2019,01,01)));

    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), movingViolationList);

    MemberModifier.field(VehicleHistory.class, "movingViolations").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "crashes").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), new ArrayList<>());
    assertFalse(validator.validation());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class, License.class})
  public void testValidatorFailedOnCrash() throws IllegalAccessException {
    MemberModifier.field(Driver.class, "birthday").
        set(objectToRegister.getDriverToRegister().getDriver(), LocalDate.of(1990,2,2));
    MemberModifier.field(VehicleInsuranceInformation.class, "owner").
        set(objectToRegister.getVehicleToRegister().getVehicleInsuranceInformation(), new Driver("A", "B", LocalDate.of(1990,02,02)));
    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), new ArrayList<>());

    List<MovingViolation> movingViolationList = new ArrayList<>();
    movingViolationList.add(new MovingViolation(
        MovingViolationType.DistractedDriving, LocalDate.of(2019,01,01)));

    MemberModifier.field(DriverHistory.class, "movingViolations").
        set(objectToRegister.getDriverToRegister().getDriverHistory(), new ArrayList<>());

    MemberModifier.field(VehicleHistory.class, "movingViolations").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), movingViolationList);

    List<Crash> crashList = new ArrayList<>();
    crashList.add(new Crash(LocalDate.of(2019, 02,  02),
            new Driver("A", "B", LocalDate.of(1990,02,02)),CrashType.crashBodilyInjuriess));

    MemberModifier.field(VehicleHistory.class, "crashes").
        set(objectToRegister.getVehicleToRegister().getVehicleHistory(), crashList);
    assertFalse(validator.validation());
  }

}
