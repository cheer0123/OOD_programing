package edu.neu.ccs.cs5004;

import java.util.Set;

/**
 * This class represents a Interface of pool of existing accepted drivers.
 * A ObjectToRegister has validator to decide whether the object can be add to pool and a Set
 * represent the data pool.
 */
public interface IPoolOfExistingAcceptedDriver {

  /**
   * validate objectToRegister, if it fulfill the requirement, then add to the pool.
   *
   * @param objectToRegister the object to validate
   */
  void addObjectToPool(ObjectToRegister objectToRegister);

  /**
   * return the poolOfExistingAcceptedDrivers.
   *
   * @return the poolOfExistingAcceptedDrivers
   */
  Set<ObjectToRegister> getPoolOfExistingAcceptedDrivers();
}
