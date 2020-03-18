package be.pxl.student;

import be.pxl.student.entity.Account;
import be.pxl.student.util.BudgetPlannerException;
import be.pxl.student.util.BudgetPlannerImporter;
import be.pxl.student.util.BudgetPlannerMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Paths;
import java.util.List;

public class BudgetPlanner {

    private static Logger logger = LogManager.getLogger(BudgetPlanner.class);

    public static void main(String[] args) {

        String csvFile = "src/main/resources/account_payments.csv";

        try {
            logger.info("Starting import csv File");
            List<String> list = BudgetPlannerImporter.readCsvFile(Paths.get(csvFile));
            logger.info("Importing done");
            logger.info("Starting account mapping");
            List<Account> accountList = new BudgetPlannerMapper().mapAccounts(list);
            logger.info("Account mapping done");
        } catch (BudgetPlannerException e) {
            logger.error("Exception importing accounts", e);
        }
    }
}
