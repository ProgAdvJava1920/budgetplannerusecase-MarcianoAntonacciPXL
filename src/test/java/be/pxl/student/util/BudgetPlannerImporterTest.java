package be.pxl.student.util;

import be.pxl.student.BudgetPlanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetPlannerImporterTest {

    Path path = Paths.get("src/main/resources/account_payments.csv");

    @Test
    void readCsvFileShouldReturnANoneEmptyList() throws Exception{
        assertFalse(BudgetPlannerImporter.readCsvFile(path).isEmpty());
    }

    @Test
    void readCsvFileShouldReturnAListWith2Items() throws Exception {
        assertEquals(2, BudgetPlannerImporter.readCsvFile(path).size());
    }

    @Test
    void shouldThrowBudgetPlannerExceptionWhenCsvFileDoesNotExist() {
        assertThrows(BudgetPlannerException.class, () -> {
            BudgetPlannerImporter.readCsvFile(Paths.get("none"));
        } );
    }

    @Test
    void shouldThrowBudgetPlannerExceptionWhenPassingNull() {
        assertThrows(BudgetPlannerException.class, () -> {
            BudgetPlannerImporter.readCsvFile(null);
        } );
    }
}