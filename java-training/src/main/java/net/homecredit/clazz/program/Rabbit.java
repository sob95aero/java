package net.homecredit.clazz.program;

import net.homecredit.clazz.ifc.Animal;

public class Rabbit implements Animal {

    public static final String DESCRIPTION = "i am rabbit";

    public String describe() {
        return DESCRIPTION;
    }
}
