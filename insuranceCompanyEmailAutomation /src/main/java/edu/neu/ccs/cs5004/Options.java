package edu.neu.ccs.cs5004;

import java.util.Objects;

/**
 * Options is a simple class that represents command line options.
 *
 * @author Rui Cao
 * @version v0.1
 */
public class Options {

  /**
   * Customer names' file.
   */
  private String customerFile;

  /**
   * Directory.
   */
  private String directory;

  /**
   * Either email or letter template.
   */
  private String template;

  /**
   * Constructors.
   * @param customerFile Customer names' file.
   * @param directory Directory.
   * @param template Either email or letter template.
   */
  public Options(String customerFile, String directory, String template) {
    this.customerFile = customerFile;
    this.directory = directory;
    this.template = template;
  }

  /**
   * Get the customer's file.
   * @return The customer's file.
   */
  public String getCustomerFile() {
    return this.customerFile;
  }

  /**
   * Get the directory.
   * @return Directory.
   */
  public String getDirectory() {
    return this.directory;
  }

  /**
   * Get the template.
   * @return Template.
   */
  public String getTemplate() {
    return template;
  }

  /**
   * Compare if the two options are the same.
   * @param anotherOption Another option.
   * @return True if the same; false otherwise.
   */
  @Override
  public boolean equals(Object anotherOption) {
    if (this == anotherOption) {
      return true;
    }
    if (anotherOption == null || getClass() != anotherOption.getClass()) {
      return false;
    }
    Options options = (Options) anotherOption;
    return Objects.equals(customerFile, options.customerFile)
      && Objects.equals(directory, options.directory)
      && Objects.equals(template, options.template);
  }

  /**
   * Get the hashcode of the options object.
   * @return The hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(customerFile, directory, template);
  }

  /**
   * Get the string representation of the options object.
   * @return The string representation.
   */
  @Override
  public String toString() {
    return "Options{"
      + "customerFile='" + customerFile + '\''
      + ", directory='" + directory + '\''
      + ", template='" + template + '\'' + '}';
  }
}
