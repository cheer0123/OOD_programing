package edu.neu.ccs.cs5004;

/**
 * InvalidCommandLineInputException is a subclass of Exception that represents invalid command line
 *  input exception.
 *
 * @author Rui Cao
 * @version v0.1
 */
public class InvalidCommandLineInputException extends Exception {

  /**
   * Constructors.
   * @param message Exception message.
   */
  public InvalidCommandLineInputException(String message) {
    super(message);
  }

}
