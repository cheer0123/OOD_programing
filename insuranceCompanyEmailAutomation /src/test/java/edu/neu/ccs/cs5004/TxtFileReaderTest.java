package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TxtFileReaderTest {
  private TxtFileReader testTxtFileReader;
  private TxtFileReader testTxtFileReader1;
  private CsvFileReader testCsvFileReader;
  private static String CHAR_SET_NAME = "UTF-8";
  @Rule
  public final ExpectedException exception = ExpectedException.none();


  @Before
  public void setUp() throws Exception {

    testTxtFileReader =  new TxtFileReader("emailtemplate.txt");
    testTxtFileReader1 =  new TxtFileReader("");
  }

  @Test

  public void testGettemplate() {
    String template = "emailtemplate.txt";
    assertEquals("emailtemplate.txt", testTxtFileReader.getTemplate());
  }

  @Test
  public void testTxtFileReaderWithoutException() throws IOException {
    List<String> email = testTxtFileReader.readFile();
    assertEquals(email.get(0), "From:insuranceCompany@ic.com\n");
  }

  @Test
  public void testTxtFileReaderWithException() {
    List<String> email = testTxtFileReader1.readFile();
    assertTrue(email.isEmpty());
  }


  @Test
  public void testTxtFileReaderException() throws IOException {
    String template = "";
    Scanner in = new Scanner(Paths.get(template), CHAR_SET_NAME);
  }


  @Test
  public void testToString() {
    assertEquals("TxtFileReader{template='emailtemplate.txt', fileList=[]}" ,
        testTxtFileReader.toString());
  }

  @Test
  public void testEquals() {
    assertTrue(testTxtFileReader.equals(testTxtFileReader));
    assertFalse(testTxtFileReader.equals(testTxtFileReader1));
    assertFalse(testTxtFileReader.equals(testCsvFileReader));
  }

  @Test
  public void testHashCode() {
    assertNotNull(testTxtFileReader.hashCode());
  }

}