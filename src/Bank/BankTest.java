package Bank;

import org.junit.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

  @Test
  public void testGetUsers() throws Exception {
    Bank bank = new Bank();
    User user = new User("81010200131", "Jan", "Kowalski");
    bank.addUser(user);
    assertEquals(1, bank.getUsers().size());
  }

  @Test
  public void testGetAccounts() {
    Bank bank = new Bank();
    User user = new User("81010200131", "Jan", "Kowalski");
    Account account = new Account(user);
    bank.addAccount(account);
    assertEquals(1, bank.getAccounts().size());
  }

  @Test
  public void testAddUser() throws Exception {
    Bank bank = new Bank();
    User user = new User("81010200131", "Jan", "Kowalski");
    bank.addUser(user);
    List<User> users = bank.getUsers();
    assertEquals(user, users.get(0));
  }

  @Test
  public void testAddUserUserAlreadyExistsException() throws Exception {
    Bank bank = new Bank();
    User user = new User("81010200131", "Jan", "Kowalski");
    bank.addUser(user);
    Throwable exception = assertThrows(Exception.class, () -> bank.addUser(user));
    assertEquals("User already exists!", exception.getMessage());
  }

  @Test
  public void testAddAccount() {
    Bank bank = new Bank();
    User user = new User("81010200131", "Jan", "Kowalski");
    Account account = new Account(user);
    bank.addAccount(account);
    List<Account> accounts = bank.getAccounts();
    assertEquals(account, accounts.get(0));
  }

}
