package net.homecredit.clazz;

import net.homecredit.clazz.object.ImmutableKey;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImmutableTypes_test_slide_17 {

    @Test
    public void immutableString() {
        String s = "good";
        assertEquals("good", s);

        s.concat("morning");
        assertEquals("good morning", s);
    }


    @Test
    public void immutableStringWorks() { // TODO this will work, why ?
        String s = "good";
        assertEquals("good", s);

        s += " morning"; // hint here
        assertEquals("good morning", s);
    }


    @Test
    public void immutableObject() {
        ImmutableKey key = new ImmutableKey("UID", Long.valueOf(123456));
        assertEquals("UID", key.getIdentifier());
        assertEquals(Long.valueOf(123456), key.getValue());

        key.updateIdentifier("ABC");
        assertEquals("ABC", key.getIdentifier());
    }

}
