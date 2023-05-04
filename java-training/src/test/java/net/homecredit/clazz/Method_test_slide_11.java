package net.homecredit.clazz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Method_test_slide_11 {

    // TODO debug
    @Test
    public void paramsAsValue() {
        StringBuilder warriorProfession = new StringBuilder("Dragon ");
        String warriorWeapon = "Sword ";
        changeWarriorClass(warriorProfession, warriorWeapon);

        assertEquals("Dragon Knight Sword ", warriorProfession.toString() + " " + warriorWeapon);

    }

    static void changeWarriorClass(StringBuilder warriorProfession, String weapon) {
        warriorProfession.append("Knight"); // note here - this can change the object
        weapon = "Dragon " + weapon;

        weapon = null;
        warriorProfession = null; // this cant because it is in local context
    }
/////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void paramsAsValue2() {
        StringBuilder warriorProfession = new StringBuilder("Dragon ");
        String warriorWeapon = "Sword ";
        changeWarriorClass2(warriorProfession, warriorWeapon);


        assertEquals("Dragon Knight Sword ", warriorProfession.toString() + " " + warriorWeapon);
    }

    static void changeWarriorClass2(StringBuilder warriorProfession, String weapon) {
        warriorProfession.append("Knight"); // note here - this can change the object
        weapon = "Dragon " + weapon;

        warriorProfession = new StringBuilder("Elf"); // this cant because it is in local context
    }
///////////////////////////


    @Test
    public void paramsAsVariable3() {
        StringBuilder warriorProfession = new StringBuilder("Dragon ");
        String warriorWeapon = "Sword ";
        warriorProfession = changeWarriorClas3(warriorProfession, warriorWeapon);


        assertEquals("Dragon Knight Sword ", warriorProfession.toString() + " " + warriorWeapon);
    }

    static StringBuilder changeWarriorClas3(StringBuilder warriorProfession, String weapon) {
        warriorProfession.append("Knight"); // note here - this can change the object
        weapon = "Dragon " + weapon;

        weapon = null;
        warriorProfession = new StringBuilder("Elf"); // this cant because it is in local context
        return warriorProfession;
    }



}
