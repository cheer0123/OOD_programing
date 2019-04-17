package edu.neu.ccs.cs5004;

import java.util.List;

/**
 * This is Interface class read the file template to generate the file.
 * A FileGenerator has a template to read and a Pattern pat to detection specific words
 * and replace them.
 */
public interface ITxtFileReader {

  /**
  * This method detection specific words according to patten and replaced them
  * according to company's members, then put them in a list and return.
  *
  * @return a file list in which some specific words to be replaced
  */
  List<String> readFile();

}
