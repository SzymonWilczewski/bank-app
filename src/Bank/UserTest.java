package Bank;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testGetId() throws Exception {
        Bank bank = new Bank();
        User user = new User("81010200131", "Jan", "Kowalski");
        bank.addUser(user);
        assertEquals("81010200131", user.getId());
    }

    @Test
    public void testGetFirstName() throws Exception {
        Bank bank = new Bank();
        User user = new User("81010200131", "Jan", "Kowalski");
        bank.addUser(user);
        assertEquals("Jan", user.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {
        Bank bank = new Bank();
        User user = new User("81010200131", "Jan", "Kowalski");
        bank.addUser(user);
        assertEquals("Kowalski", user.getLastName());
    }

}
