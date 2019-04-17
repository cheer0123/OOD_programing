package edu.neu.ccs.cs5004;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is class generate the file accordingly for the insurance company.
 * A FileGenerator has a csvFileReader to read the members of insurance company,
 * and a txtFileReader to read the file template.
 */
public class FileGenerator implements IFileGenerator{
  private static final String PATTERN = "\\[\\[([a-z])+([_])*([a-z])+\\]\\]";
  private static final String CHAR_SET_NAME = "utf-8";
  private CsvFileReader csvFileReader;
  private TxtFileReader txtFileReader;
  private String directory;


  /**
   * Construct the FileGenerator which has a csvFileReader and a txtFileReaders.
   *
   * @param csv the string for csvFileReader to find path
   * @param txt the string for txtFileReaders to find path
   * @param directory the string for output directory
   */
  public FileGenerator(String csv, String txt, String directory) {
    this.txtFileReader = new TxtFileReader(txt);
    this.csvFileReader = new CsvFileReader(csv);
    this.directory = directory;
  }

  /**
   * This is method to generate the contents of the file(email or letter) into a list.
   *
   * @param txtFileReader the txtFileReader input
   * @return a list in which including the contents of the file(email or letter)
   * @throws Exception if the CsvFileReader didn't find the file to read
   */
  private void writeFiles(TxtFileReader txtFileReader) throws Exception {
    Pattern patten = Pattern.compile(PATTERN);

    for (Map<String, String> record :csvFileReader.parseFile()) {
      Writer writer = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream(
          this.directory + txtFileReader.getTemplate() + "_"
              + record.get("email") + ".txt"), CHAR_SET_NAME)
      );
      for (String string: txtFileReader.readFile()) {
        Matcher matcher = patten.matcher(string);
        String toBeReplaced = "";
        while (matcher.find()) {
          toBeReplaced = string.substring(matcher.start(), matcher.end());
          String key = toBeReplaced.replaceAll("\\[\\[","")
              .replaceAll("\\]\\]","");
          if (record.containsKey(key)) {
            string = string.replace(toBeReplaced, record.get(key));
            matcher = patten.matcher(string);
          }
        }
        writer.write(string);
        writer.flush();
      }
      writer.close();
    }
  }

  /**
   * generateFiles using file writer according to txtFileReaders.
   *
   * @throws Exception if txtFileReader failed.
   */
  public void generateFiles() throws Exception {
    writeFiles(txtFileReader);
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
    if (!(object instanceof FileGenerator)) {
      return false;
    }
    FileGenerator that = (FileGenerator) object;
    return csvFileReader.equals(that.csvFileReader)
        && txtFileReader.equals(that.txtFileReader);
  }

  /**
   * return the hash code of this class.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(csvFileReader, txtFileReader);
  }

  /**
   * return the string type of this class.
   *
   * @return the string type
   */
  @Override
  public String toString() {
    return "EmailGenerator{" + "csvFileReader=" + csvFileReader
        + ", txtFileReader=" + txtFileReader + '}';
  }
}
