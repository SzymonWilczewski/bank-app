package Bank;

import org.junit.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void testGetAmount() {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        account.deposit(1000);
        Transaction transaction = account.getHistory().getTransactions().get(0);
        assertEquals(1000, transaction.getAmount(), 0);
    }

    @Test
    public void testGetType() {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        account.deposit(1000);
        Transaction transaction = account.getHistory().getTransactions().get(0);
        assertEquals("deposit", transaction.getType());
    }

    @Test
    public void testGetDate() {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        account.deposit(1000);
        Transaction transaction = account.getHistory().getTransactions().get(0);
        assertEquals(new Date().toString(), transaction.getDate().toString());
    }

    @Test
    public void testGetSender() throws Exception {
        User sender = new User("81010200131", "Jan", "Kowalski");
        User receiver = new User("72033012345", "Anna", "Kowalska");
        Account senderAccount = new Account(sender);
        Account receiverAccount = new Account(receiver);
        senderAccount.deposit(1000);
        senderAccount.outgoingTransfer(1000, receiverAccount);
        Transaction transaction = senderAccount.getHistory().getTransactions().get(1);
        assertEquals(senderAccount, transaction.getSender());
    }

    @Test
    public void testGetReceiver() throws Exception {
        User sender = new User("81010200131", "Jan", "Kowalski");
        User receiver = new User("72033012345", "Anna", "Kowalska");
        Account senderAccount = new Account(sender);
        Account receiverAccount = new Account(receiver);
        senderAccount.deposit(100);
        senderAccount.outgoingTransfer(100, receiverAccount);
        Transaction transaction = senderAccount.getHistory().getTransactions().get(1);
        assertEquals(receiverAccount, transaction.getReceiver());
    }

}
