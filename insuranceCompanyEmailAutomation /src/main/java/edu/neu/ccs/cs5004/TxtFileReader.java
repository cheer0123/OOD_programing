package edu.neu.ccs.cs5004;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This is class read the file template to generate the file.
 * A FileGenerator has a template to read and a Pattern PATTERN to detection specific words
 * and replace them.
 */
public class TxtFileReader implements ITxtFileReader{

  private static final String CHAR_SET_NAME = "UTF-8";
  private static final Pattern PATTERN = Pattern.compile(".*\\R|.+\\z");
  private String template;
  private List<String> fileList;


  /**
   * Construct a TxtFileReader including template to generate the file.
   *
   * @param template the template to generate the file
   */
  public TxtFileReader(String template) {
    this.template = template;
    fileList = new ArrayList<>();
  }

  public String getTemplate() {
    return template;
  }

  /**
   * This method detection specific words according to patten and replaced them
   * according to company's members, then put them in a list and return.
   *
   * @return a file list in which some specific words to be replaced
   */
  public List<String> readFile() {
    if (!fileList.isEmpty()) {
      fileList.clear();
    }
    try (Scanner scanner = new Scanner(Paths.get(template), CHAR_SET_NAME)) {
      String line;
      while ((line = scanner.findWithinHorizon(PATTERN, 0)) != null) {
        fileList.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fileList;
  }

  /**
   * Return a boolean whether they are equal.
   *
   * @param object the object to compare
   * @return a boolean whether they are equal
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof TxtFileReader)) {
      return false;
    }
    TxtFileReader that = (TxtFileReader) object;
    return Objects.equals(template, that.template);
  }

  /**
   * return the hash code of this class.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(template, fileList);
  }

  /**
   * return the string type of this class.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "TxtFileReader{" + "template='" + template + '\'' + ", fileList=" + fileList + '}';
  }
}
