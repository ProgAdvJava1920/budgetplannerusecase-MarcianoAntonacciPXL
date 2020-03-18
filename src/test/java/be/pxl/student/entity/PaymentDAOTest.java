package be.pxl.student.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentDAOTest {

    private static final String DB_URL = "jdbc:h2:mem:test;MODE=MySQL;INIT=RUNSCRIPT FROM 'classpath:BudgetPlannerTest.sql'";
    PaymentDAO dao;
    DAOManager manager;

    @BeforeEach
    void setUp() {
        manager = new DAOManager(DB_URL);
        dao = new PaymentDAO(manager);
    }

    @AfterEach
    void tearDown() {
        manager.close();
    }

    @Test
    void create() {
        fail("not implemented yet");
    }

    @Test
    void getById() {
        fail("not implemented yet");
    }

    @Test
    void getAll() {

    }

    @Test
    void update() {
        fail("not implemented yet");
    }

    @Test
    void delete() {
        fail("not implemented yet");
    }
}