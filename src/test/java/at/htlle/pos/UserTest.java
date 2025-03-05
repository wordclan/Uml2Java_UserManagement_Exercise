package at.htlle.pos;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;

    @BeforeEach
    public void setup() {
        user = new User(3, "Lisa", "BartSucks!");
    }

    @Test
    public void testConstructor() {
        user = new User(3, "homer", "*****");
        assertEquals(3, user.getId());
        assertEquals("homer", user.getUsername());
        assertEquals("*****", user.getPassword());
    }

    @Test
    public void testConstructorWithUsernameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new User(3, null, "*****"));
    }

    @Test
    public void testConstructorWithUsernameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "", "*****"));
    }

    @Test
    public void testConstructorWithUsernameIsBlanksTabsOrNewlines() {
        // only blanks
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "   ", "+++++"));

        // only tabs
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "\t\t", "+++++"));

        // only newlines
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "\n\n", "+++++"));

        // blanks mixed with tabs and newlines
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "\n\t\n\t  ", "+++++"));
    }

    @Test
    public void testConstructorWithPasswordIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "homer", null));
    }

    @Test
    public void testConstructorWithPasswordIsEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "homer", ""));
    }

    @Test
    public void testConstructorWithPasswordIsBlanksTabsOrNewlines() {
        // only blanks
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "homer", "  "));

        // only tabs
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "homer", "\t\t"));

        // only newlines
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "homer", "\n\n"));

        // blanks mixed with tabs and newlines
        assertThrows(IllegalArgumentException.class, () ->
                new User(3, "homer", "\t\n\t\n  "));
    }

    @Test
    public void testConstructorWithIdIsNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new User(-3, "homer", "*****"));
    }

    @Test
    public void testSetAndGetGroup() {
        assertNull(user.getGroup());
        Group g = new Group(12, "Simpsons");
        user.setGroup(g);
        assertNotNull(user.getGroup());
        assertEquals(g, user.getGroup());
    }

    @Test
    public void testSetAndGetUsername() {
        assertEquals("Lisa", user.getUsername());
        user.setUsername("Maggie");
        assertEquals("Maggie", user.getUsername());
    }

    @Test
    public void testSetAndGetPassword() {
        assertEquals("BartSucks!", user.getPassword());
        user.setPassword("Bart'sNice!");
        assertEquals("Bart'sNice!", user.getPassword());
    }

    @Test
    public void testToString() {
        User u = new User(3, "homer", "*****");
        final String EXPECTED = "3,homer,*****";
        assertEquals(EXPECTED, u.toString());
    }

    @Test
    void testEquals() {
        // Think what this test implies...
        Entity entity = new EntityTest();
        entity.setId(user.getId());
        assertEquals(user, entity);
    }

    @Test
    void testHashCode() {
        // Think what this test implies...
        Entity entity = new EntityTest();
        entity.setId(user.getId());
        assertEquals(user.hashCode(), entity.hashCode());
    }

}
