package net.homecredit.clazz.object;

public class Dolphin extends Mammal {

    @Override
    public String getBreed() {
        throw new NoBreedException("Dolphin does not have breed.");
    }
}
