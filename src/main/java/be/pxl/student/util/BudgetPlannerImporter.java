package be.pxl.student.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Util class to import csv file
 */
public class BudgetPlannerImporter {

    public static List<String> readCsvFile(Path csvPath) throws BudgetPlannerException {
        List<String> csvLines = new ArrayList<>();

        try(BufferedReader reader = Files.newBufferedReader(csvPath)) {
            String line = reader.readLine(); //ignore first line
            while ( (line = reader.readLine()) != null) {
                csvLines.add(line);
            }
        } catch (IOException | NullPointerException ex) {
            throw new BudgetPlannerException("Something went wrong");
        }

        return csvLines;
    }
}
