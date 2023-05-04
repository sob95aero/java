package net.homecredit.clazz;

import net.homecredit.clazz.object.Bulldog;
import net.homecredit.clazz.program.Terrier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BasicDataTypes_test_slide_14 {

    @Test
    public void bytee() {
        // from -128 to +127
        byte a = 124;
        byte b = 76;

        byte result = (byte) (a + b);

        assertEquals(-56, result); // 200 - 256(two full bytes)
    }

    @Test
    public void shorte() {
        // from -32,768 to +32,767
        short a = 32767;
        short b = 10;

        short result = (short) (a + b);

        assertEquals(-32759, result); // overflow and count from Short.MIN_VALUE
    }


    @Test
    public void reference() {
        Object dog = null;
        assertNull(dog);

        dog = new Bulldog();
        assertNotNull(dog);

        dog = new Terrier();
        assertNotNull(dog);

        assertEquals(dog.getClass(), Terrier.class);

        // TODO task
        // where the Bulldog went ?
    }

}
