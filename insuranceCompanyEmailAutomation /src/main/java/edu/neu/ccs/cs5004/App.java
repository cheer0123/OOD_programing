package edu.neu.ccs.cs5004;

import java.util.Arrays;
import java.util.List;

/**
 * Application class.
 */
public class App {

  /**
   * Command line Input.
   * @param args Command line arguments.
   * @throws Exception when csv file is not valid.
   */
  public static void main(String[] args) throws Exception {

    CommandLineParser parser = new CommandLineParser();
    List<String> argsList = Arrays.asList(args);
    try {
      Options options = parser.parse(argsList);

      FileGenerator fileGenerator = new FileGenerator(options.getCustomerFile(),
          options.getTemplate(), options.getDirectory());

      fileGenerator.generateFiles();
    } catch (InvalidCommandLineInputException e) {
      System.out.println(e.getMessage());
      System.out.println("Usage:\n"
          + " --email only generate email messages\n"
          + " --email-template <file> accept a filename that holds the email template.\n"
          + " Required if --email is used\n"
          + " --letter only generate letters\n"
          + " --letter-template <file> accept a filename that hold the email template.\n"
          + " Required if --letter is used\n"
          + " --output-dir <path> accept the name of a folder, all output is placed in this "
          + "folder\n"
          + " --csv-file <path> accept the name of the csv file to process\n"
          + "Examples:\n"
          + " --email --email-template email-template.txt --output-dir emails "
          + "--csv-file customer.csv"
          + "\n"
          + " --letter --letter-template letter-template.txt --output-dir letters"
          + "--csv-file customer.csv");
    }
  }
}


