package net.homecredit.clazz;

import net.homecredit.clazz.object.Animal;
import net.homecredit.clazz.object.Bulldog;
import net.homecredit.clazz.object.Dolphin;
import net.homecredit.clazz.object.ImmutableKey;
import net.homecredit.clazz.program.Terrier;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArraysMapsCollections_test_slide_18 {

    @Test
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }

    @Test
    public void testAssertListEquals() {
        Animal[] animals = new Animal[3];
        animals[0] = new Bulldog();
        animals[1] = new Terrier();
        animals[2] = new Dolphin();
        assertEquals(3, animals.length);


        List<Animal> animalList = Arrays.asList(animals);
        assertEquals(3, animalList.size());

        boolean allFound = true;
        for (int i = 0; i < animals.length; i++) {
            allFound &= animalList.contains(animals[i]);
        }
        assertTrue(allFound);
    }


    @Test
    public void testMap() {
        Map animals = new HashMap();

        ImmutableKey dogKey = new ImmutableKey("dog", Long.valueOf(123));
        Terrier terrier = new Terrier();
        animals.put(dogKey, terrier);

        assertEquals(animals.get(dogKey), terrier);

        Bulldog bulldog = new Bulldog();
        animals.put(dogKey, bulldog);

        assertEquals(animals.get(dogKey), bulldog);

    }

}
