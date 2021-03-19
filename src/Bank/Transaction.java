package Bank;

import java.util.*;

public class Transaction {
    private final double amount;
    private final String type;
    private final Date date;
    private final Account sender;
    private final Account receiver;

    public Transaction(double amount, String type, Date date) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.sender = null;
        this.receiver = null;
    }

    public Transaction(double amount, String type, Date date, Account sender, Account receiver) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }
}
