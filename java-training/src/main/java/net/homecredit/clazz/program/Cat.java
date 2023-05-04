package net.homecredit.clazz.program;

import net.homecredit.clazz.ifc.Animal;
import net.homecredit.clazz.ifc.Behave;
import net.homecredit.clazz.ifc.Mammal;

public class Cat implements Mammal, Animal, Behave {

    public static final String DESCRIPTION = "i am cat";

    public void doVoice() {
        System.out.println("meow");
    }

    public void sleep() {

    }

    public void eat() {

    }

    public String describe() {
        return DESCRIPTION;
    }
}
