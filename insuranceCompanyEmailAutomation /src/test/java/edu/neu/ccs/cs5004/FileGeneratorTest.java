package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FileGeneratorTest {
  FileGenerator fileGenerator1;
  FileGenerator fileGenerator2;
  FileGenerator fileGenerator3;
  TxtFileReader testTxtFileReader;

  @Before
  public void setUp() throws Exception {
    fileGenerator1 = new FileGenerator("insurance_company_members.csv", "lettertemplate.txt", "A");
    fileGenerator2 = new FileGenerator("insurance_company_members.csv", "dummy.txt", "B");
    fileGenerator3 = new FileGenerator("dummy.csv", "lettertemplate.txt", "C");
    testTxtFileReader =  new TxtFileReader("emailtemplate.txt");
  }

  @Test
  public void generateFiles() {
  }

  @Test
  public void writeFiles() throws Exception {
    fileGenerator1.generateFiles();
  }

  @Test
  public void equals() {
    assertTrue(fileGenerator1.equals(fileGenerator1));
    assertFalse(fileGenerator1.equals(fileGenerator2));
    assertFalse(fileGenerator1.equals(fileGenerator3));
    assertFalse(fileGenerator1.equals(testTxtFileReader));
  }

  @Test
  public void testHashCode() {
    assertNotNull(fileGenerator1.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("EmailGenerator{csvFileReader=insurance_company_members.csv, "
        + "txtFileReader=TxtFileReader{template='lettertemplate.txt', fileList=[]}}" , fileGenerator1
        .toString());
  }
}