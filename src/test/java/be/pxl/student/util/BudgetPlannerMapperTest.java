package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetPlannerMapperTest {

    List<String> accountLines;
    Path path = Paths.get("src/main/resources/account_payments.csv");
    BudgetPlannerMapper mapper;
    String testDataLine = "Jos,BE69771770897312,BE17795215960626,Thu Feb 13 05:47:35 CET 2020,265.8,EUR,Ut ut necessitatibus itaque ullam.";


    @BeforeEach
    void setUp() throws BudgetPlannerException {
        mapper = new BudgetPlannerMapper();
        accountLines = BudgetPlannerImporter.readCsvFile(path);
    }

    @Test
    void itShouldReturnNonEmptyList() {
        assertFalse(mapper.mapAccounts(accountLines).isEmpty());
    }

    @Test
    void itShouldMapToAccountListWith1Account() {
        List<Account> accountList = mapper.mapAccounts(accountLines);
        assertEquals(1, accountList.size(), "List should have 1 account");
    }

    @Test
    void itShouldMapToAccountListWith1AccountWith2Payments() {
        List<Account> accountList = mapper.mapAccounts(accountLines);
        assertEquals(2, accountList.get(0).getPayments().size(), "Account should have 2 payments");
    }

    @Test
    void itShouldMapLineToAccountObject() {
        Account expectedAccount = new Account("Jos", "BE69771770897312");
        Account lineToAccount = mapper.mapDataLineToAccount(testDataLine);
        assertEquals(expectedAccount, lineToAccount);
    }

    @Test
    void ItShouldMapLineToPayment() throws ParseException {
        Payment expectedPayment = new Payment(
                "BE17795215960626",
                 mapper.convertToDate("Thu Feb 13 05:47:35 CET 2020"),
                265.8f,
                "EUR",
                "Ut ut necessitatibus itaque ullam."
        );


    }

    @Test
    void itShouldConvertDate() throws ParseException {
        String testDate = "Thu Feb 13 05:47:35 CET 2020";
        Date date = mapper.convertToDate(testDate);
        String dateToString = mapper.convertDateToString(date);
        assertEquals(testDate, dateToString);
    }
}