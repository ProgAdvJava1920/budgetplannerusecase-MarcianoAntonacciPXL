package be.pxl.student.entity;

import java.util.List;

public class PaymentDAO implements DAO<Payment, PaymentException> {

    private DAOManager manager;

    public PaymentDAO(DAOManager manager) {
        this.manager = manager;
    }

    @Override
    public Payment create(Payment payment) throws PaymentException {
        throw new PaymentException("not implemented yet");
    }

    @Override
    public Payment getById(int id) throws PaymentException {
        throw new PaymentException("not implemented yet");
    }

    @Override
    public List<Payment> getAll() throws PaymentException {
        throw new PaymentException("not implemented yet");
    }

    @Override
    public Payment update(Payment payment) throws PaymentException {
        throw new PaymentException("not implemented yet");
    }

    @Override
    public Payment delete(Payment payment) throws PaymentException {
        throw new PaymentException("not implemented yet");
    }
}
