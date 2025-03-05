package at.htlle.pos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroupTest {
    private Group group;
    private User user1, user2;

    @BeforeEach
    public void setup() {
        group = new Group(1, "students");

        user1 = new User(3, "homer", "***");
        group.addUser(user1);
        user1.setGroup(group);

        user2 = new User(5, "marge", "***");
        group.addUser(user2);
        user2.setGroup(group);
    }


    @Test
    public void testGetUsers() {
        assertEquals(2, group.getUsers().size());

        assertEquals(user1, group.getUsers().get(0));
        assertEquals(user2, group.getUsers().get(1));

        assertEquals("homer", group.getUsers().get(0).getUsername());
        assertEquals("marge", group.getUsers().get(1).getUsername());
    }


    @Test
    public void testAssignmentUserToGroup() {
        User u1 = group.getUsers().get(0);
        assertEquals(user1.getUsername(), u1.getUsername());

        assertEquals(group.getName(), u1.getGroup().getName());
    }

    @Test
    public void testConstructor() {
        Group g1 = new Group(2099, "Tha Group");
        assertEquals(g1.getName(), "Tha Group");
        assertEquals(g1.getId(), 2099);
        assertNotNull(g1.getUsers());
        assertTrue(g1.getUsers().isEmpty());
    }

    @Test
    public void testConstructorWithIdIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Group(-200, "Tha Group"));
    }

    @Test
    public void testConstructorWithNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Group(200, null));
    }

    @Test
    public void testConstructorWithNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Group(200, ""));
    }

    @Test
    public void testConstructorWithNameIsBlanksTabsOrNewlines() {
        // only blanks
        assertThrows(IllegalArgumentException.class, () -> new Group(200, "  "));
        // only tabs
        assertThrows(IllegalArgumentException.class, () -> new Group(200, "\t\t"));
        // only newlines
        assertThrows(IllegalArgumentException.class, () -> new Group(200, "\n\n"));
        // blanks mixed with tabs and newlines
        assertThrows(IllegalArgumentException.class, () -> new Group(200, "\t\n "));
    }

    @Test
    void testEquals() {
        // Think what this test implies...
        Entity entity = new EntityTest();
        entity.setId(group.getId());
        assertEquals(group, entity);
    }

    @Test
    void testHashCode() {
        // Think what this test implies...
        Entity entity = new EntityTest();
        entity.setId(group.getId());
        assertEquals(group.hashCode(), entity.hashCode());
    }

    @Test
    void testToString() {
        group.addUser(user1);
        final String EXPECTED = "1,students,[3,homer,***, 5,marge,***, 3,homer,***]";
        assertEquals(EXPECTED, group.toString());
    }

}
