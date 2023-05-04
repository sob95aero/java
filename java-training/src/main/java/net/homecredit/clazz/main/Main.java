package net.homecredit.clazz.main;

import net.homecredit.clazz.ifc.Behave;
import net.homecredit.clazz.program.Cat;
import net.homecredit.clazz.program.Dog;
import net.homecredit.clazz.program.SilentDog;

public class Main {
    public static void main(String[] args) {
        Behave dog = new Dog();
        dog.doVoice();

        Behave cat = new Cat();
        cat.doVoice();

        Dog pet = new SilentDog();
        pet.doVoice();
    }
}


