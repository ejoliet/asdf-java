package edu.caltech.ipac.roman.asdfparser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import org.yaml.snakeyaml.Yaml;
import java.util.Map;

public class AsdfReader {
    public static void main(String[] args) throws IOException {
        // Adjust the file path as needed
        String filePath = "path_to_your_asdf_file.asdf";

        try (FileInputStream fis = new FileInputStream(filePath)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
            Yaml yaml = new Yaml();
            String line;
            StringBuilder headerContent = new StringBuilder();

            // Read the YAML header
            while ((line = reader.readLine()) != null && !line.startsWith("%YAML")) {
                headerContent.append(line).append("\n");
            }

            // Parse the header
            Map<String, Object> header = yaml.load(headerContent.toString());
            System.out.println("Header: " + header);

            // The rest of the file is binary data (FITS)
            // Further processing depends on the specifics of the FITS format
        }
    }
}
