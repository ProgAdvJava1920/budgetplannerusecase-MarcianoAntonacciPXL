package be.pxl.student.entity;

import java.util.Date;

public class Payment {

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
