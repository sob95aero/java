package net.homecredit.clazz.object;

import net.homecredit.clazz.program.Dog;

public class Bulldog extends Dog {
    private int weight;

    public final String bloodSystem = "BULLDOG-BLOODED";

    public int calculateWeight() {
        this.weight = this.age*2;
        return  this.weight;
    }

}
