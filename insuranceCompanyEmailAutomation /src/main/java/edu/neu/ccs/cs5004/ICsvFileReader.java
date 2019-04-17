package edu.neu.ccs.cs5004;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

/**
 * This is the interface for Class CsvFileReader. It contains 5 functions.
 */
public interface ICsvFileReader {

  /**
   * This function will parse the file using BufferReader.
   *
   * @return A list of HashMap contains header as key and information as value.
   * @throws Exception when there are no available lines.
   */
  List<HashMap<String, String>> parseFile() throws Exception;

  /**
   * This function will construct a new FileReader using file path as an input.
   *
   * @return A reader
   * @throws IOException when there are no available lines.
   */

  Reader getReader() throws IOException;


  /**
   * This function will compare two CsvFileReader.
   *
   * @param compareCsvFileReader The new one we need to compare.
   * @return True or false.
   */


  boolean equals(Object compareCsvFileReader);

  /**
   * This function will calculate the hashcode.
   *
   * @return Int.
   */

  int hashCode();

  /**
   * This function will make the input to String.
   *
   * @return String.
   */

  String toString();

}
