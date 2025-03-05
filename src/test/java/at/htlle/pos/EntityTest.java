package at.htlle.pos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest extends Entity {


    @BeforeEach
    void setUp() {
        setId(10);
    }

    @Test
    void testGetId() {
        assertEquals(10,getId());
    }

    @Test
    void testSetId() {
        setId(5);
        assertEquals(5, getId());
        setId(6);
        assertEquals(6, getId());
    }

    @Test
    void testEquals(){
        Entity entity = new EntityTest();
        entity.setId(this.getId());
        assertEquals(this, entity);
    }

    @Test
    void testHashCode(){
        Entity entity = new EntityTest();
        entity.setId(this.getId());
        assertEquals(this.hashCode(), entity.hashCode());
    }

    @Test
    void testSetIdWithNegativeId(){
        assertThrows(IllegalArgumentException.class, ()->setId(-1));
    }

    @Test
    void testToString(){
        final String EXPECTED = "10";
        assertEquals(EXPECTED, this.toString());
    }

}