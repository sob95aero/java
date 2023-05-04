package net.homecredit.clazz.program;

import net.homecredit.clazz.ifc.Behave;
import net.homecredit.clazz.object.Mammal;

public class Dog extends Mammal implements Behave {

    public static final String TAXONOMY = "VERTEBRATE";

    public void doVoice() {
        System.out.println("bark");
    }

    public void sleep() {

    }

    public void eat() {

    }

}

