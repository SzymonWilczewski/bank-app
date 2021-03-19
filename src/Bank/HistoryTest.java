package Bank;

import org.junit.*;

import java.text.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class HistoryTest {

    @Test
    public void testGetTransactions() {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        List<Transaction> transactions = account.getHistory().getTransactions();
        assertEquals(0, transactions.size());
    }

    @Test
    public void testGetTransactionsStartEnd() throws Exception {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        account.deposit(1000);
        account.deposit(1000);
        String currentYear = new SimpleDateFormat("yyyy").format(new Date());
        Date start = new SimpleDateFormat("yyyy/MM/dd").parse(currentYear + "/01/01");
        Date end = new SimpleDateFormat("yyyy/MM/dd").parse(currentYear + "/12/31");
        List<Transaction> transactions = account.getTransactions(start, end);
        assertEquals(2, transactions.size());
    }

    @Test
    public void testGetTransactionsStartEndNoTransactions() throws Exception {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        account.deposit(500);
        account.deposit(500);
        String nextYear = String.valueOf(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())) + 1);
        Date start = new SimpleDateFormat("yyyy/MM/dd").parse(nextYear + "/01/01");
        Date end = new SimpleDateFormat("yyyy/MM/dd").parse(nextYear + "/12/31");
        List<Transaction> transactions = account.getTransactions(start, end);
        assertEquals(0, transactions.size());
    }

    @Test
    public void testAddTransactionDepositWithdraw() {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        account.deposit(1000);
        Transaction transaction = account.getHistory().getTransactions().get(0);
        assertEquals("deposit", transaction.getType());
    }

    @Test
    public void testAddTransactionIncomingOutgoingTransfer() throws Exception {
        User sender = new User("81010200131", "Jan", "Kowalski");
        User receiver = new User("72033012345", "Anna", "Kowalska");
        Account senderAccount = new Account(sender);
        Account receiverAccount = new Account(receiver);
        senderAccount.deposit(100);
        senderAccount.outgoingTransfer(50, receiverAccount);
        Transaction transaction = senderAccount.getHistory().getTransactions().get(1);
        assertEquals("outgoingTransfer", transaction.getType());
    }

}
