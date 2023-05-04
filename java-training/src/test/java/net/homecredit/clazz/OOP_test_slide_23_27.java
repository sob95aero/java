package net.homecredit.clazz;

import net.homecredit.clazz.ifc.Animal;
import net.homecredit.clazz.object.Bulldog;
import net.homecredit.clazz.object.Dolphin;
import net.homecredit.clazz.object.abstr.Point;
import net.homecredit.clazz.object.abstr.Pyramid;
import net.homecredit.clazz.object.abstr.Shape;
import net.homecredit.clazz.object.abstr.Triangle;
import net.homecredit.clazz.program.Cat;
import net.homecredit.clazz.program.Dog;
import net.homecredit.clazz.program.Rabbit;
import net.homecredit.clazz.program.SilentDog;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OOP_test_slide_23_27 {

    @Test
    public void encapsulation() {
        Dog bulldog = new Bulldog();
        bulldog.setAge(5);

        bulldog.setColor("brown");

        assertEquals(5, bulldog.getAge());
        assertEquals("brown", bulldog.getColor());

        // TODO cant call: bulldog.weight = 25

        int weight = ((Bulldog) bulldog).calculateWeight();

        assertEquals(10, weight);
    }

    @Test
    public void inheritanceInterface() { // inherits describe() method
        Animal cat = new Cat();
        assertEquals(Cat.DESCRIPTION, cat.describe());

        Animal rabbit = new Rabbit();

        assertEquals(Rabbit.DESCRIPTION, rabbit.describe());
    }


    @Test
    public void inheritanceObject() {
        net.homecredit.clazz.object.Mammal dolphin = new Dolphin();
        dolphin.setColor("gray");

        assertEquals("WARM-BLOODED", dolphin.bloodSystem);

        net.homecredit.clazz.object.Animal dog = new SilentDog(5);

        assertEquals(5, dog.getAge());
    }

    @Test
    public void inheritanceAbstract() {
        Shape triangle = new Triangle();
        String draw = triangle.draw();
        assertEquals("Point{x=0, y=0}; Point{x=0, y=10}; Point{x=10, y=0};", draw);

        Shape pyramid = new Pyramid();
        String pyramidDrawing = pyramid.draw();
        // TODO this will fail.. why ? how to fix this ?
//        assertEquals("Point3D{z=0, x=0, y=0}; Point3D{z=0, x=0, y=10}; Point3D{z=0, x=10, y=0}; Point3D{z=0, x=10, y=10}; Point3D{z=10, x=5, y=5};", pyramidDrawing);
    }

    @Test
    public void polymorphismCompile() { // runtime example see above test
        Shape triangle = new Triangle();

        String draw = triangle.draw();

        assertEquals("Point{x=0, y=0}; Point{x=0, y=10}; Point{x=10, y=0};", draw);

        draw = triangle.draw("cant draw myself");

        assertEquals("cant draw myself", draw);

        Shape square = new Shape() {
            @Override
            public Point[] getCoordinates() {
                return new Point[0];
            }
        };

        draw = square.draw(new Point[]{new Point(0, 0), new Point(0, 10), new Point(10, 0), new Point(10, 10)});
        assertEquals("Point{x=0, y=0}; Point{x=0, y=10}; Point{x=10, y=0}; Point{x=10, y=10};", draw);

        Shape pint = new Shape() {
            @Override
            public Point[] getCoordinates() {
                return new Point[] {new Point(50, 50)};
            }
        };

        draw = pint.draw();
        assertEquals("Point{x=50, y=50};", draw);


    }


}
