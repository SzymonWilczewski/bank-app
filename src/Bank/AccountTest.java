package Bank;

import org.junit.*;

import java.text.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testGetUser() {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        assertEquals(user, account.getUser());
    }

    @Test
    public void testGetBalance() {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        assertEquals(0, account.getBalance(), 0);
    }

    @Test
    public void testGetHistory() {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        History history = new History();
        assertEquals(history.getClass(), account.getHistory().getClass());
    }

    @Test
    public void testGetTransactions() throws Exception {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        account.deposit(1000);
        account.withdraw(500);
        Date start = new SimpleDateFormat("yyyy/MM/dd").parse("2021/01/01");
        Date end = new SimpleDateFormat("yyyy/MM/dd").parse("2021/12/31");
        List<Transaction> transactions = account.getTransactions(start, end);
        assertEquals(2, transactions.size());
    }

    @Test
    public void testDeposit() {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        account.deposit(1000);
        assertEquals(1000, account.getBalance(), 0);
    }

    @Test
    public void testWithdraw() throws Exception {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        account.deposit(1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance(), 0);
    }

    @Test
    public void testWithdrawNotEnoughMoneyException() {
        User user = new User("81010200131", "Jan", "Kowalski");
        Account account = new Account(user);
        Throwable exception = assertThrows(Exception.class, () -> account.withdraw(1000));
        assertEquals("Not enough money!", exception.getMessage());
    }

    @Test
    public void testIncomingTransfer() throws Exception {
        User sender = new User("81010200131", "Jan", "Kowalski");
        User receiver = new User("72033012345", "Anna", "Kowalska");
        Account senderAccount = new Account(sender);
        Account receiverAccount = new Account(receiver);
        senderAccount.deposit(1000);
        senderAccount.outgoingTransfer(500, receiverAccount);
        assertEquals(500, receiverAccount.getBalance(), 0);
    }

    @Test
    public void testOutgoingTransfer() throws Exception {
        User sender = new User("81010200131", "Jan", "Kowalski");
        User receiver = new User("72033012345", "Anna", "Kowalska");
        Account senderAccount = new Account(sender);
        Account receiverAccount = new Account(receiver);
        senderAccount.deposit(1000);
        senderAccount.outgoingTransfer(100, receiverAccount);
        assertEquals(900, senderAccount.getBalance(), 0);
    }

    @Test
    public void testOutgoingTransferNotEnoughMoneyException() {
        User sender = new User("81010200131", "Jan", "Kowalski");
        User receiver = new User("72033012345", "Anna", "Kowalska");
        Account senderAccount = new Account(sender);
        Account receiverAccount = new Account(receiver);
        Throwable exception = assertThrows(Exception.class, () -> senderAccount.outgoingTransfer(1000, receiverAccount));
        assertEquals("Not enough money!", exception.getMessage());
    }

}
