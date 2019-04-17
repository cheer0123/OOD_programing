package edu.neu.ccs.cs5004;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

public class CsvFileReaderTest {
  CsvFileReader testCsvFileReader;
  @Before
  public void setUp() throws Exception {
      this.testCsvFileReader = new CsvFileReader("dummyPath"){
      @Override
      public Reader getReader() throws IOException {
        return new StringReader("\"A\",\"B\"\n\"1,2\",\"3,4\"");
      }
    };
  }

  @Test
  public void parseFile() {
    boolean throwedException = false;
    List<HashMap<String, String>> temp = null;
    try{
       temp = this.testCsvFileReader.parseFile();
    }catch (Exception e){
      throwedException = true;
    }
    Assert.assertTrue(!throwedException);
    Assert.assertEquals(temp.size(), 1);
    Assert.assertEquals(temp.get(0).get("A"), "1,2");
    Assert.assertEquals(temp.get(0).get("B"), "3,4");
  }
}