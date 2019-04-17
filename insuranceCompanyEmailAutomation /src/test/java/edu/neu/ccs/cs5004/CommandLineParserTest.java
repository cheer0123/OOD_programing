package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CommandLineParserTest {
  private CommandLineParser commandLineParser;

  @Before
  public void setUp() throws Exception {
    commandLineParser = new CommandLineParser();
  }

  @Test
  public void testEmailParse() {
    List<String> args = new ArrayList<>();
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }

    args.add("--email");
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }

    args.add("--csv-file");
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }

    args.add("customer.csv");
    args.add("--output-dir");
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }

    args.add("dir");
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }

    args.add("--email-template");
    args.add("template");
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }

    args.remove("template");
    args.add("template.txt");
    try {
      Options options = commandLineParser.parse(args);
      assertEquals("customer.csv", options.getCustomerFile());
    } catch (Exception e) {
      assertTrue(false);
    }
  }

  @Test
  public void testLetterParse() {
    List<String> args = new ArrayList<>();

    args.add("--letter");
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }

    args.add("--csv-file");
    args.add("customer.csv");
    args.add("--output-dir");
    args.add("dir");
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }

    args.add("email");
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }

    args.remove("email");
    args.add("--letter-template");
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }
    args.add("template");
    try {
      Options options = commandLineParser.parse(args);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof InvalidCommandLineInputException);
    }

    args.remove("template");
    args.add("template.txt");
    try {
      Options options = commandLineParser.parse(args);
      assertEquals("customer.csv", options.getCustomerFile());
    } catch (Exception e) {
      assertTrue(false);
    }
  }

  @Test
  public void testEquals() {
    assertTrue(commandLineParser.equals(commandLineParser));
    assertFalse(commandLineParser.equals(null));
  }

  @Test
  public void testHashCode() {
    assertEquals(commandLineParser.hashCode(), commandLineParser.hashCode());
  }

  @Test
  public void testToString() {
    CommandLineParser anotherParser = new CommandLineParser();
    assertEquals(commandLineParser.toString(), anotherParser.toString());
  }
}