package net.homecredit.clazz;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TypesTest {
    @Test
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }

}
