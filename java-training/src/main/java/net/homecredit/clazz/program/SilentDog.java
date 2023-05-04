package net.homecredit.clazz.program;

public class SilentDog extends Dog {

    public SilentDog() {
    }

    public SilentDog(int age) {
        super.age = age;
    }

    @Override
    public void doVoice() {
        System.out.println("--silence--");
    }
}


