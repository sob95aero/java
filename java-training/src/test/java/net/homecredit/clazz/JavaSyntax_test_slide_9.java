package net.homecredit.clazz;

import net.homecredit.clazz.object.Animal;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JavaSyntax_test_slide_9 {

    @Test
    public void object() {
        Animal tiger = new Animal();
        assertEquals(tiger.getClass(), Animal.class);
        assertTrue(tiger instanceof Animal);
    }

    @Test
    public void clazz() throws NoSuchFieldException {
        Class<Animal> animalClass = Animal.class;
        Field colorField = animalClass.getDeclaredField("color");

        assertEquals("color", colorField.getName());
    }

    @Test
    public void method() throws NoSuchMethodException {
        Class<Animal> animalClass = Animal.class;
        Method ageMethod = animalClass.getDeclaredMethod("getAge");

        assertEquals("getAge", ageMethod.getName());
    }

    // TODO task
    // Question.. how can i access static method on the class?


    @Test
    public void instanceVariables() {
        Animal tiger = new Animal();
        tiger.setAge(15);
        tiger.setColor("orange black stripes");

        tiger.setBreed("bengal"); // is this correct? what do you think .. should not the breed / or species be in the another place?

        assertEquals("bengal", tiger.getBreed());
        assertEquals(15, tiger.getAge());
        assertEquals("orange black stripes", tiger.getColor());
    }

}
