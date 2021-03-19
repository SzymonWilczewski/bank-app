package Bank;

import java.util.*;

public class Account {
    private final User user;
    private double balance;
    private final History history;

    public Account(User user) {
        this.user = user;
        balance = 0;
        history = new History();
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public History getHistory() {
        return history;
    }

    public List<Transaction> getTransactions(Date start, Date end) {
        return history.getTransactions(start, end);
    }

    public void deposit(double amount) {
        balance += amount;
        history.addTransaction(amount, "deposit", new Date());
    }

    public void withdraw(double amount) throws Exception {
        if (balance - amount >= 0) {
            balance -= amount;
            history.addTransaction(amount, "withdraw", new Date());
        } else {
            throw new Exception("Not enough money!");
        }
    }

    private void incomingTransfer(double amount, Account sender) {
        balance += amount;
        history.addTransaction(amount, "incomingTransfer", new Date(), sender, this);
    }

    public void outgoingTransfer(double amount, Account receiver) throws Exception {
        if (balance - amount >= 0) {
            balance -= amount;
            receiver.incomingTransfer(amount, this);
            history.addTransaction(amount, "outgoingTransfer", new Date(), this, receiver);
        } else {
            throw new Exception("Not enough money!");
        }
    }
}
