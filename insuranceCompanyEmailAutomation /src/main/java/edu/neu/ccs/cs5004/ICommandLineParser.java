package edu.neu.ccs.cs5004;

import java.util.List;

/**
 * ICommandLineParser is an interface that includes the function of CommandLineParser.
 *
 * @author Rui Cao
 * @version v0.1
 */
public interface ICommandLineParser {

  /**
   * Parse the arguments of command line.
   *
   * @param args Command line arguments.
   * @return Options provided in command line.
   * @throws InvalidCommandLineInputException when having invalid command line input.
   */
  Options parse(List<String> args) throws InvalidCommandLineInputException;
}
