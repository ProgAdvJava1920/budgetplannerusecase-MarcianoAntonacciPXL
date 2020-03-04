package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BudgetPlannerMapper {

    private static final String DATE_PATTERN = "EEE MMM d HH:mm:ss z yyyy";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN, Locale.US);
    private static final int CSV_ITEM_COUNT = 7;
    private Map<String, Account> accountMap = new HashMap<>();

    public List<Account> mapAccounts(List<String> accountLines) {

        for (String accountLine : accountLines) {
            try {
                Account account = mapDataLineToAccount(accountLine);
                accountMap.putIfAbsent(account.getIBAN(), account);
            } catch (Exception e) {
                System.err.println("Could not parse line: " + accountLine);
            }

        }
        return new ArrayList<>(accountMap.values());
    }

    public Account mapDataLineToAccount(String line) throws BudgetPlannerException, ParseException {
        String[] items = line.split(",");

        if(items.length != CSV_ITEM_COUNT) {
            throw new BudgetPlannerException(String.format("Line should contain %d items", CSV_ITEM_COUNT));
        }

        String name = items[0];
        String IBAN = items[1];

        Account account = accountMap.getOrDefault(IBAN, new Account(name, IBAN));
        Payment payment = mapItemsToPayment(items);
        account.getPayments().add(payment);

        return account;
    }

    public Date convertToDate(String dateString) throws BudgetPlannerException, ParseException {
        return DATE_FORMAT.parse(dateString);
    }


    public String convertDateToString(Date date) {
        return DATE_FORMAT.format(date);
    }

    public Payment mapItemsToPayment(String[] items) throws BudgetPlannerException, ParseException {
        return new Payment(
            items[2],                       //counterIBAN
            convertToDate(items[3]),        //date
            Float.parseFloat(items[4]),     //amount
            items[5],                       //currency
            items[6]                        //description
        );
    }
}
