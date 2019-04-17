package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** This class will take CSV file as a input and parse the record into a list of HashMaps.
 * Ever HashMap takes the header as key and the information as value.
 *
 *  @author Fan Fan
 *  @version v0.1
 */

public class CsvFileReader implements ICsvFileReader {

  private String path;

  /** Construct a CsvFileReader.
   *
   * @param path The CSV file path.
   */
  public CsvFileReader(String path) {
    this.path = path;
  }

  /** This function will parse the file using BufferReader.
   *
   * @return A list of HashMap contains header as key and information as value.
   * @throws Exception when there are no available lines.
   */

  public List<HashMap<String, String>> parseFile() throws Exception {
    List<HashMap<String, String>> res = new ArrayList<HashMap<String, String>>();
    BufferedReader bufferedReader = null;
    String line = "";
    int count = 0;
    List<String> headers = null;
    try {
      bufferedReader = new BufferedReader(getReader());
      while ((line = bufferedReader.readLine()) != null) {
        count++;
        if (count == 1) {
          // parse header
          headers = parseHeader(line);
          continue;
        }

        HashMap<String, String> record = parseRecord(line, headers);
        if (record != null) {
          res.add(record);
        }
      }
    } finally {
      if (bufferedReader != null) {
        bufferedReader.close();
      }
    }

    return res;
  }

  /** This function will construct a new FileReader using file path as an input.
   *
   * @return A reader
   * @throws IOException when there are no available lines.
   */

  public Reader getReader() throws IOException {
    return new InputStreamReader(new FileInputStream(path), Charset.defaultCharset());

  }

  /** This function will take line and list of headers to parse the record and return HashMap.
   *
   * @param line The line needs to parse.
   * @param header A list of String contains all the headers.
   * @return A HashMap has header as key and information as value.
   */

  private HashMap<String, String> parseRecord(String line, List<String> header) {
    List<String> parsedRecord = separateHelper(line);
    HashMap<String, String> res = new HashMap<String, String>();
    if (header.size() != parsedRecord.size()) {
      return null;
    }
    for (int i = 0; i < header.size(); i++) {
      res.put(header.get(i), parsedRecord.get(i));
    }

    return res;
  }

  /** This function will take the header line and return a list.
   *
   * @param line of header.
   * @return A list of header.
   */

  private List<String> parseHeader(String line) {
    return separateHelper(line);
  }

  /** This function will help separate each keywords using two pointers, separating by "".
   *
   * @param line The line of record that needs to parse.
   * @return A list of string of information.
   */

  private List<String> separateHelper(String line) {
    List<String> res = new ArrayList<String>();
    // char[] temp = line.toCharArray();
    int start = 0;
    int end = 1;
    while (start < line.length()) {
      while (end < line.length() && line.charAt(end) != '"') {
        end++;
      }
      res.add(line.substring(start + 1, end));

      start = end + 1;
      while (start < line.length() && line.charAt(start) != '"') {
        start++;
      }
      end = start + 1;
    }
    return res;
  }

  /** This function will compare two CsvFileReader.
   *
   * @param compareCsvFileReader The new one we need to compare.
   * @return True or false.
   */

  @Override
  public boolean equals(Object compareCsvFileReader) {
    if (compareCsvFileReader == this) {
      return true;
    }

    if (compareCsvFileReader == null) {
      return false;
    }

    if (!(compareCsvFileReader instanceof CsvFileReader)) {
      return false;
    }

    CsvFileReader input = (CsvFileReader) compareCsvFileReader;

    if (!this.path.equals(input.path)) {
      return false;
    }

    return true;

  }

  /** This function will calculate the hashcode.
   *
   * @return Int.
   */

  @Override
  public int hashCode() {
    int hashCode = 7;
    for (char c : this.path.toCharArray()) {
      hashCode = hashCode * 31 + (int)c;
    }
    return hashCode;
  }

  /** This function will make the input to String.
   *
   * @return String.
   */
  @Override
  public String toString() {
    return this.path;
  }
}