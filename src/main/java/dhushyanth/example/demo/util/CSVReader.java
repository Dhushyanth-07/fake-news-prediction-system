package dhushyanth.example.demo.util;

import java.io.*;
import java.util.*;

public class CSVReader {

    // smaller limit = faster + safer
    private static final int LIMIT = 5000;

    public static List<String> readCSV(String path) throws Exception {

        List<String> data = new ArrayList<>();

        InputStream is = CSVReader.class
                .getClassLoader()
                .getResourceAsStream(path);

        if (is == null) {
            throw new FileNotFoundException("File not found: " + path);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        boolean skipHeader = true;
        int count = 0;

        while ((line = br.readLine()) != null && count < LIMIT) {

            // skip header
            if (skipHeader) {
                skipHeader = false;
                continue;
            }

            // safe CSV split
            String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            //  USE ONLY TITLE (column 0)
            if (parts.length >= 1) {
                String title = parts[0].replace("\"", "").toLowerCase();

                if (!title.isBlank()) {
                    data.add(title);
                    count++;
                }
            }
        }

        br.close();
        return data;
    }
}