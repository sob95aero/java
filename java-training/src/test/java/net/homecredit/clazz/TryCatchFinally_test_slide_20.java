package net.homecredit.clazz;

import net.homecredit.clazz.object.Dolphin;
import net.homecredit.clazz.object.NoBreedException;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class TryCatchFinally_test_slide_20 {

    @Test(expected = java.nio.file.NoSuchFileException.class)
    public void testCheckedException() throws IOException {
        try {
            byte[] bytes =   Files.readAllBytes(Paths.get("app.log"));
        } catch (IOException e) {
            throw e;
        }
    }

    @Test(expected = ArithmeticException.class) // RuntimeException
    public void testUncheckedArithmeticException() {
        int x = 0;
        int y = 10;
        try {
            int z = y / x;
        } catch (ArithmeticException e) {
            throw e;
        }
    }

    @Test(expected = NoBreedException.class)
    public void testCustomException() {
        String executed = "";
        try {
            new Dolphin().getBreed();
        } finally {
            executed = "executed in finally";
        }
        assertEquals("executed in finally", executed);
    }


}
