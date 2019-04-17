package edu.neu.ccs.cs5004;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This class represents a pool of existing accepted drivers.
 * A ObjectToRegister has validator to dicide whether the object can be add to pool and a Set
 * represent the data pool.
 */
public class PoolOfExistingAcceptedDrivers implements IPoolOfExistingAcceptedDriver {
  private Validator validator;
  public Set<ObjectToRegister> poolOfExistingAcceptedDrivers;

  /**
   * construct a a pool of existing accepted drivers.
   *
   * @param objectToRegister the objectToRegister to add to pool
   */
  public PoolOfExistingAcceptedDrivers(ObjectToRegister objectToRegister) {
    this.validator = new Validator(objectToRegister);
    this.poolOfExistingAcceptedDrivers = new HashSet<>();
  }

  /**
   * validate objectToRegister, if it fulfill the requirement, then add to the pool.
   *
   * @param objectToRegister the object to validate
   */
  public void addObjectToPool(ObjectToRegister objectToRegister) {
    if (validator.validation()) {
      poolOfExistingAcceptedDrivers.add(objectToRegister);
    }
  }

  /**
   * return the poolOfExistingAcceptedDrivers.
   *
   * @return the poolOfExistingAcceptedDrivers
   */
  public Set<ObjectToRegister> getPoolOfExistingAcceptedDrivers() {
    return poolOfExistingAcceptedDrivers;
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
    if (!(object instanceof PoolOfExistingAcceptedDrivers)) {
      return false;
    }
    PoolOfExistingAcceptedDrivers that = (PoolOfExistingAcceptedDrivers) object;
    return validator.equals(that.validator)
        && poolOfExistingAcceptedDrivers.equals(that.poolOfExistingAcceptedDrivers);
  }

  /**
   * return the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(validator, poolOfExistingAcceptedDrivers);
  }

  /**
   * return the string type.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "PoolOfExistingAcceptedDrivers{" + "validator=" + validator
        + ", poolOfExistingAcceptedDrivers=" + poolOfExistingAcceptedDrivers + '}';
  }
}
