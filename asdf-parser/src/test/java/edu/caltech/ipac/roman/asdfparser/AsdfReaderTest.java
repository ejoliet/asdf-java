package edu.caltech.ipac.roman.asdfparser;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

// Run:
// mvn test
public class AsdfReaderTest {

    @Test
    public void testReadYamlHeader() {
        try{
          String yamlContent = "#ASDF 1.0.0\n---\nkey: value\n...";
        InputStream inputStream = new ByteArrayInputStream(yamlContent.getBytes(StandardCharsets.UTF_8));

        AsdfReader reader = new AsdfReader();
        String header = reader.readYamlHeader(inputStream);

        assertNotNull("Header should not be null", header);
        assertTrue("Header should contain 'key: value'", header.contains("key: value"));
      }catch(Exception e){

      }

    }

    @Test
   public void testReadYamlHeaderFromResourceFile() {
       try{
         InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test.asdf");
         assertNotNull("Input stream must not be null", inputStream);

         AsdfReader reader = new AsdfReader();
         String yamlHeader = reader.readYamlHeader(inputStream);
         assertNotNull("YAML header should not be null", yamlHeader);
      }catch(Exception e){

      }
       // You can add more assertions here to check specific contents of the YAML header
   }
}
