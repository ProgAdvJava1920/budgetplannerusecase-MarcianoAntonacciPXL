package be.pxl.student.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountDAOTest {

    private static final String DB_URL = "jdbc:h2:mem:test;MODE=MySQL;INIT=RUNSCRIPT FROM 'classpath:BudgetPlannerTest.sql'";
    AccountDAO dao;
    DAOManager manager;

    @BeforeEach
    void setUp() {
        manager = new DAOManager(DB_URL);
        dao = new AccountDAO(manager);
    }

    @AfterEach
    void tearDown() {
        manager.close();
    }

    @Test
    void itShouldAddAnAccountToTheDatabase() throws AccountException {
        int originalSize = dao.getAll().size();
        Account newAccount = new Account("dummyIBAN3", "dummyName3");
        dao.create(newAccount);
        int newSize = dao.getAll().size();
        assertEquals(originalSize + 1, newSize);
    }

    @Test
    void itShouldReturn2Items() throws AccountException {
        List<Account> accounts = dao.getAll();

        assertEquals(2, accounts.size());
    }

    @Test
    void itShouldReturnAccountWithId1() throws AccountException {
        Account account = dao.getById(1);

        Account expected = new Account(1, "dummyIBAN", "dummyName");
        assertEquals(expected, account);
    }

    @Test
    void update() {
        fail("Not yet implemented");

    }

    @Test
    void delete() {
        fail("Not yet implemented");

    }
}