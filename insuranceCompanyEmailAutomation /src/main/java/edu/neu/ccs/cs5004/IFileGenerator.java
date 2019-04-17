package edu.neu.ccs.cs5004;

/**
 * This is Interface class generate the file accordingly for the insurance company.
 * A FileGenerator has a csvFileReader to read the members of insurance company,
 * and a txtFileReader to read the file template.
 */
public interface IFileGenerator {
  /**
   * generateFiles using file writer according to txtFileReaders.
   *
   * @throws Exception if txtFileReader failed.
   */
  void generateFiles() throws Exception;

}
