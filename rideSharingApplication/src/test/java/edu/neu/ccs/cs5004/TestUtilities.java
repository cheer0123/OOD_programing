package edu.neu.ccs.cs5004;

import edu.neu.ccs.cs5004.driver.register.Driver;
import edu.neu.ccs.cs5004.driver.register.DriverHistory;
import edu.neu.ccs.cs5004.driver.register.DriverToRegister;
import edu.neu.ccs.cs5004.driver.register.License;
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

public class TestUtilities {

  private static MovingViolation movingViolation;
  private static NonMovingViolation nonMovingViolation;
  private static Crash crash;
  private static List<MovingViolation> movingViolations;
  private static List<NonMovingViolation> nonMovingViolations;
  private static List<Crash> crashes;

  private static VehicleHistory vehicleHistory;
  private static DriverHistory driverHistory;

  private static Driver offendingDriver;
  private static VehicleInformation vehicleInformation;

  private static Driver owner;
  private static List<Driver> coveredDrivers;
  private static LocalDate expirationDate;
  private static VehicleInsuranceInformation vehicleInsuranceInformation;

  private static DriverToRegister driverToRegister;
  private static VehicleToRegister vehicleToRegister;
  private static Driver driver;
  private static License license;

  public static VehicleHistory creatVehicleHistory(){
    movingViolation = new MovingViolation(
        MovingViolationType.DrivingUnderInfluence, LocalDate.of(2019, 3, 1));
    movingViolations = new ArrayList<>();
    movingViolations.add(movingViolation);

    nonMovingViolation = new NonMovingViolation(NonMovingViolationType.ParkingViolation,
        LocalDate.of(2019, 4, 1));

    nonMovingViolations = new ArrayList<>();
    nonMovingViolations.add(nonMovingViolation);

    offendingDriver = new Driver("A", "B", LocalDate.of(1992,02,12));
    crash = new Crash(LocalDate.of(2019, 1, 2), offendingDriver,
        CrashType.crashWithoutBodilyInjuriess);

    crashes = new ArrayList<>();
    crashes.add(crash);

    vehicleHistory = new VehicleHistory(movingViolations, nonMovingViolations, crashes);

    return vehicleHistory;
  }

  public static DriverHistory creatDriverHistory() {
    movingViolation = new MovingViolation(
        MovingViolationType.DrivingUnderInfluence, LocalDate.of(2019, 3, 1));
    movingViolations = new ArrayList<>();
    movingViolations.add(movingViolation);

    nonMovingViolation = new NonMovingViolation(NonMovingViolationType.ParkingViolation,
        LocalDate.of(2019, 4, 1));
    nonMovingViolations = new ArrayList<>();
    nonMovingViolations.add(nonMovingViolation);

    crash = new Crash(LocalDate.of(2019, 1, 2), offendingDriver,
        CrashType.crashWithoutBodilyInjuriess);

    driverHistory = new DriverHistory(movingViolations, nonMovingViolations);
    return driverHistory;
  }

  public static DriverToRegister creatDriverToRegister() {
    driver = new Driver("A", "B", LocalDate.of(1992, 02, 12));
    license = new License("123456WA", driver, "400 Boren Ave",
        "US", "WA", LocalDate.of(2016, 1, 23),
        LocalDate.of(2022, 1, 23));
    DriverHistory driverHistory = creatDriverHistory();
    driverToRegister = new DriverToRegister(driverHistory, driver, license);
    return driverToRegister;
  }

  public static VehicleToRegister creatVehicleToRegister() {
    driver = new Driver("A", "B", LocalDate.of(1992, 02, 12));
    vehicleInformation = new VehicleInformation("VW", "Golf", 2016, driver);
    owner = new Driver("C", "D", LocalDate.of(1993,02,12));
    coveredDrivers = new ArrayList<>();
    expirationDate = LocalDate.of(2020,1,2);
    vehicleInsuranceInformation = new VehicleInsuranceInformation(
        owner,coveredDrivers,expirationDate);

    vehicleHistory = creatVehicleHistory();

    vehicleToRegister = new VehicleToRegister(vehicleInformation,
          vehicleHistory,
          vehicleInsuranceInformation);
    return vehicleToRegister;
  }

  public static VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }
}
