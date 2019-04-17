package edu.neu.ccs.cs5004;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

import edu.neu.ccs.cs5004.driver.register.Driver;
import edu.neu.ccs.cs5004.driver.register.DriverHistory;
import edu.neu.ccs.cs5004.vehicle.register.VehicleHistory;
import edu.neu.ccs.cs5004.vehicle.register.VehicleInsuranceInformation;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;

public class PoolOfExistingAcceptedDriversTest {
  private PoolOfExistingAcceptedDrivers poolOfExistingAcceptedDrivers;
  private PoolOfExistingAcceptedDrivers poolOfExistingAcceptedDrivers2;
  private Validator validator;

  ObjectToRegister objectToRegister = new ObjectToRegister(TestUtilities.creatVehicleToRegister()
      , TestUtilities.creatDriverToRegister());

  @Before
  public void setUp() {
    poolOfExistingAcceptedDrivers = new PoolOfExistingAcceptedDrivers(objectToRegister);
    poolOfExistingAcceptedDrivers2 = new PoolOfExistingAcceptedDrivers(objectToRegister);
  }

  @Test
  public void testAddObjectToPoolFailedValidation() {
    poolOfExistingAcceptedDrivers.addObjectToPool(objectToRegister);
    assertTrue(poolOfExistingAcceptedDrivers.getPoolOfExistingAcceptedDrivers().isEmpty());
  }

  @Test
  public void testgetPoolOfExistingAcceptedDrivers() {
    assertTrue(poolOfExistingAcceptedDrivers.getPoolOfExistingAcceptedDrivers().isEmpty());
  }

  @Test
  @PrepareForTest({VehicleInsuranceInformation.class, Driver.class, DriverHistory.class})
  public void testAddObjectToPoolHappyCase() throws IllegalAccessException {
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
    poolOfExistingAcceptedDrivers.addObjectToPool(objectToRegister);
    assertEquals(1, poolOfExistingAcceptedDrivers.getPoolOfExistingAcceptedDrivers().size());
  }

  @Test
  public void testHashCode() {
    assertNotNull(objectToRegister.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertFalse(poolOfExistingAcceptedDrivers.equals(poolOfExistingAcceptedDrivers2));
    Assert.assertTrue(poolOfExistingAcceptedDrivers.equals(poolOfExistingAcceptedDrivers));
    Assert.assertFalse(poolOfExistingAcceptedDrivers.equals(objectToRegister));
  }
}
