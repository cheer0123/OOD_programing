package edu.neu.ccs.cs5004;

import java.util.List;

/**
 * CommandLineParser is a simple class that represents a command line parser.
 *
 * @author Rui Cao
 * @version v0.1
 */
public class CommandLineParser implements ICommandLineParser {

  /**
   * Constructors.
   */
  public CommandLineParser() {
  }

  /**
   * Parse the arguments of command line.
   * @param args Command line arguments.
   * @return Options provided in command line.
   * @throws InvalidCommandLineInputException when having invalid command line input.
   */
  @Override
  public Options parse(List<String> args) throws InvalidCommandLineInputException {
    String emailTemplate = parseEmailTemplate(args);
    String letterTemplate = parseLetterTemplate(args);
    String customerFile = parseCustomerFile(args);
    String directory = parseOutputDir(args);
    boolean isEmail = checkEmail(args);
    boolean isLetter = checkLetter(args);

    if (isEmail && emailTemplate != null && customerFile != null
        && directory != null) {
      return new Options(customerFile, directory, emailTemplate);
    }

    if (isLetter && letterTemplate != null && customerFile != null
        && directory != null) {
      return new Options(customerFile, directory, letterTemplate);
    }

    if (customerFile == null || directory == null) {
      throw new InvalidCommandLineInputException("The command line option --output-dir and "
        + "--csv-file are required. ");
    }

    if (isEmail && emailTemplate == null) {
      throw new InvalidCommandLineInputException(" --email provided but no --email-template "
        + "was given.");
    }
    if (isLetter && letterTemplate == null) {
      throw new InvalidCommandLineInputException(" --letter provided but no --letter-template "
        + "was given.");
    }

    throw new InvalidCommandLineInputException("Invalid command line input.");
  }

  /**
   * Check if having email command.
   * @param args Command line arguments.
   * @return True if have; false otherwise.
   */
  private static boolean checkEmail(List<String> args) {
    return args.contains("--email");
  }

  /**
   * Check if having letter command.
   * @param args Command line arguments.
   * @return True if have; false otherwise.
   */
  private static boolean checkLetter(List<String> args) {
    return args.contains("--letter");
  }

  /**
   * Parse the email template command.
   * @param args Command line arguments.
   * @return Email template filename.
   * @throws InvalidCommandLineInputException when no template file has been provided.
   */
  private static String parseEmailTemplate(List<String> args) throws
      InvalidCommandLineInputException {
    for (int i = 0; i < args.size(); i ++) {
      if (args.get(i).equals("--email-template")) {
        if (i < args.size() - 1 && args.get(i + 1).endsWith(".txt")) {
          return args.get(i + 1);
        } else {
          throw new InvalidCommandLineInputException("Email template file is required.");
        }
      }
    }
    return null;
  }

  /**
   * Parse the letter template command.
   * @param args Command line arguments.
   * @return Letter template filename.
   * @throws InvalidCommandLineInputException when no template file has been provided.
   */
  private static String parseLetterTemplate(List<String> args) throws
      InvalidCommandLineInputException {
    for (int i = 0; i < args.size(); i ++) {
      if (args.get(i).equals("--letter-template")) {
        if (i < args.size() - 1 && args.get(i + 1).endsWith(".txt")) {
          return args.get(i + 1);
        } else {
          throw new InvalidCommandLineInputException("Letter template file is required.");
        }
      }
    }
    return null;
  }

  /**
   * Parse the customer csv file command.
   * @param args Command line arguments.
   * @return Customer filename.
   * @throws InvalidCommandLineInputException when no csv file has been provided.
   */
  private static String parseCustomerFile(List<String> args) throws
      InvalidCommandLineInputException {
    for (int i = 0; i < args.size(); i ++) {
      if (args.get(i).equals("--csv-file")) {
        if (i < args.size() - 1 && args.get(i + 1).endsWith(".csv")) {
          return args.get(i + 1);
        } else {
          throw new InvalidCommandLineInputException("Customer file is required.");
        }
      }
    }
    return null;
  }

  /**
   * Parse output directory command.
   * @param args Command line arguments.
   * @return Directory folder name.
   * @throws InvalidCommandLineInputException when no directory has been provided.
   */
  private static String parseOutputDir(List<String> args) throws InvalidCommandLineInputException {
    for (int i = 0; i < args.size(); i ++) {
      if (args.get(i).equals("--output-dir")) {
        if (i < args.size() - 1 && !args.get(i + 1).startsWith("--")) {
          String directory = args.get(i + 1);
          if (!directory.endsWith("/")) {
            directory = directory + "/";
          }
          return directory;
        } else {
          throw new InvalidCommandLineInputException("Directory path is required.");
        }
      }
    }
    return null;
  }

  /**
   * Determine if the two command line parsers are the same.
   * @param obj Another command line parser.
   * @return True if the same; false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * Get the hashcode of the commandline parser.
   * @return The hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Get the string representation of the commandline parser.
   * @return The string representation.
   */
  @Override
  public String toString() {
    return "CommandLineParser{}";
  }
}
