package edu.neu.ccs.cs5004.driver.register;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class represents a Driver. A Driver has a firstName, a last name and a birthday
 */
public class Driver {

  private String firstName;
  private String lastName;
  private LocalDate birthday;


  /**
   *Construct a Driver object that has a firstName, a last name and a birthday.
   *
   * @param firstName firstName of driver
   * @param lastName lastName of driver
   * @param birthday birthday of driver
   */
  public Driver(String firstName, String lastName, LocalDate birthday) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = birthday;
  }

  /**
   * return  first name.
   *
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * return  last name.
   *
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }


  /**
   * return birthday.
   *
   * @return birthday
   */
  public LocalDate getBirthday() {
    return birthday;
  }

  /**
   * Return a boolean whether they are equal.
   *
   * @param object the object to compare
   * @return a boolean whether they are equal
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Driver)) {
      return false;
    }
    Driver driver = (Driver) object;
    return firstName.equals(driver.firstName) && lastName.equals(driver.lastName)
        && birthday.isEqual(driver.getBirthday());
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, birthday);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "Driver{" + "firstName='"
        + firstName + '\'' + ", lastName='"
        + lastName + '\''
        + ", birthday=" + birthday + '}';
  }
}
