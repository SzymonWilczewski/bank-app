package Bank;

import java.util.*;
import java.util.stream.*;

public class History {
    private final List<Transaction> history = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return history;
    }

    public List<Transaction> getTransactions(Date start, Date end) {
        return history.stream()
                .filter(d -> d.getDate().after(start) && d.getDate().before(end))
                .collect(Collectors.toList());
    }

    public void addTransaction(double amount, String type, Date date) {
        history.add(new Transaction(amount, type, date));
    }

    public void addTransaction(double amount, String type, Date date, Account sender, Account receiver) {
        history.add(new Transaction(amount, type, date, sender, receiver));
    }
}
