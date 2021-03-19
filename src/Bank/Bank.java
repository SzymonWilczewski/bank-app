package Bank;

import java.util.*;

public class Bank {
  private final List<User> users = new ArrayList<>();
  private final List<Account> accounts = new ArrayList<>();

  public List<User> getUsers() {
    return users;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void addUser(User user) throws Exception {
    if (users.stream().noneMatch(x -> user.getId().equals(x.getId()))) {
      users.add(user);
    } else {
      throw new Exception("User already exists!");
    }
  }

  public void addAccount(Account account) {
    accounts.add(account);
  }
}
