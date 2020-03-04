package be.pxl.student.util;

public class BudgetPlannerException extends Exception {
    public BudgetPlannerException(String msg) {
        super(msg);
    }

    public BudgetPlannerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BudgetPlannerException(Throwable cause) {
        super(cause);
    }
}
