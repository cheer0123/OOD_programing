package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OptionsTest {
  private Options options;

  @Before
  public void setUp() {
    options = new Options("customer", "directory", "template");
  }

  @Test
  public void testGetCustomerFile() {
    assertEquals("customer", options.getCustomerFile());
  }

  @Test
  public void testGetDirectory() {
    assertEquals("directory", options.getDirectory());
  }

  @Test
  public void testGetTemplate() {
    assertEquals("template", options.getTemplate());
  }

  @Test
  public void testEquals() {
    assertTrue(options.equals(options));
    assertFalse(options.equals(null));
    assertFalse(options.equals("string"));

    Options anotherOptions = new Options("customer", "directory",
      "template");
    assertTrue(options.equals(anotherOptions));

    Options anotherOptions1 = new Options("customers", "directory",
      "template");
    assertFalse(options.equals(anotherOptions1));
  }

  @Test
  public void testHashCode() {
    Options anotherOptions = new Options("customer", "directory",
      "template");
    assertEquals(options.hashCode(), anotherOptions.hashCode());
  }

  @Test
  public void testToString() {
    Options anotherOptions = new Options("customer", "directory",
      "template");
    assertEquals(options.toString(), anotherOptions.toString());
  }
}