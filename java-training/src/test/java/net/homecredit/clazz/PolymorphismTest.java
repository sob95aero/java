package net.homecredit.clazz;

import net.homecredit.clazz.ifc.Animal;
import net.homecredit.clazz.program.Cat;
import net.homecredit.clazz.program.Rabbit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PolymorphismTest {
    @Test
    public void catIsAnimal() {
        Animal cat = new Cat();
        assertEquals(Cat.DESCRIPTION, cat.describe());
    }

    @Test
    public void rabbitIsNotACat() {
        Animal rabbit = new Rabbit();
        assertEquals("failure - rabbit is not a cat", Cat.DESCRIPTION, rabbit.describe());
    }

}
