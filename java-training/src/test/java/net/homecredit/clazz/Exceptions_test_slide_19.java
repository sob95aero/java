package net.homecredit.clazz;

import net.homecredit.clazz.object.Dolphin;
import net.homecredit.clazz.object.NoBreedException;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exceptions_test_slide_19 {

    @Test(expected = java.nio.file.NoSuchFileException.class)
    public void testCheckedException() throws java.nio.file.NoSuchFileException, IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("app.log"));
    }

    @Test(expected = ArithmeticException.class) // RuntimeException
    public void testUncheckedArithmeticException() {
        int x = 0;
        int y = 10;
        int z = y / x;
    }

    public void testError() {
        int x = 0;
        int y = 10;
        //int z = a / b; // TODO compilation error

        // for (i = 1; i <= 5; i++ { // TODO compilation error
        // }

    }

    @Test(expected = NoBreedException.class)
    public void testCustomException() {
        new Dolphin().getBreed();
    }


}
