package net.homecredit.clazz;

import net.homecredit.clazz.object.Bulldog;
import net.homecredit.clazz.program.Dog;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Modifiers_test_slide_15 {

    @Test
    public void accessControl() {
        Dog dog = new Bulldog();
        dog.setAge(10);

        assertEquals("VERTEBRATE", Dog.TAXONOMY); // public (and also static - belongs to class Dog)
        // TODO task
        // dog.weight // cant be accessed - its private

        assertEquals(10, dog.protectedAgeFromAnimal()); // protected access from Animal via super keyword.

        assertEquals("BULLDOG-BLOODED", ((Bulldog) dog).bloodSystem); // final in Mammal class - we cant override this

    }

    @Test
    public void arithmeticOperators() {
        int start = 0;

        start += 1;

        assertEquals(1, start);

        start -= 10;

        assertEquals(-9, start);
    }

    @Test
    public void relationalOperators() {
        int first = 1;
        int second = 1;

        assertTrue(first == second);


        Dog dog1 = new Bulldog();
        Dog dog2 = new Bulldog();
        assertTrue(dog1 == dog1);
        assertFalse(dog1 == dog2);

        // TODO task
        // assertEquals(dog1, dog2); // this will fail, how to solve ? ;-) (fail this because default equals is over == )
    }


}
