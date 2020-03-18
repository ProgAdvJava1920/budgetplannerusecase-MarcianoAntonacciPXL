package be.pxl.student.entity;

import java.util.Date;
import java.util.Objects;

public class Payment {

    private int id;
    private int accountId;
    private int counterAccountId;
    private String counteracountIBAN;
    private Date date;
    private float amount;
    private String currency;
    private String detail;

    public Payment(String counteraccountIBAN, Date date, float amount, String currency, String detail) {
        this.counteracountIBAN = counteraccountIBAN;
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.detail = detail;
    }

    public Payment(int id, int accountId, int counterAccountId, String counteracountIBAN, Date date, float amount, String currency, String detail) {
        this.id = id;
        this.accountId = accountId;
        this.counterAccountId = counterAccountId;
        this.counteracountIBAN = counteracountIBAN;
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.detail = detail;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCounterAccountId() {
        return counterAccountId;
    }

    public void setCounterAccountId(int counterAccountId) {
        this.counterAccountId = counterAccountId;
    }

    public String getCounteracountIBAN() {
        return counteracountIBAN;
    }

    public void setCounteracountIBAN(String counteracountIBAN) {
        this.counteracountIBAN = counteracountIBAN;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Float.compare(payment.amount, amount) == 0 &&
                Objects.equals(counteracountIBAN, payment.counteracountIBAN) &&
                Objects.equals(date, payment.date) &&
                Objects.equals(currency, payment.currency) &&
                Objects.equals(detail, payment.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(counteracountIBAN, date, amount, currency, detail);
    }

    @Override
    public String toString() {
        return "{" +
                "counteraccount IBAN=" + counteracountIBAN +
                "date=" + date +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
