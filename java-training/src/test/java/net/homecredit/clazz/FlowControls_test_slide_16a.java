package net.homecredit.clazz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlowControls_test_slide_16a {

    @Test
    public void whileLoop() {
        int i = 0;

        while (i < 10) {
            ++i; // or i+=1 or i++.. what is the difference?
        }
        assertEquals(10, i);

    }

    @Test
    public void doWhileLoop() {
        int i = 0;
        do {
            ++i;
        } while (i < 10);
        assertEquals(10, i);
    }


    @Test
    public void whileLoopNext() {
        int i = 10;

        while (i > 0 && i < 10) {
            i--;
        }
        assertEquals(0, i);

    }

    @Test
    public void doWhileLoopNext() {
        int i = 10;
        do {
            i--;
        } while (i > 0 && i < 10);
        assertEquals(0, i);
    }

    @Test
    public void forLoop() {
        for (int i = 0; i < 10; i++) {

        }
        // TODO task
        // assertEquals(9, i); this will not work, why ?
    }

    @Test
    public void forLoopBreak() {
        int i;
        for (i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
        }
        assertEquals(5, i);
    }

    @Test
    public void forLoopContinue() { // a game ? :-)
        int i = 0; // remark : implicit initialization can be omitted
        int y = 0;
        for (i = 0; i < 100; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
//                System.out.println(i);
                continue;
            }
            y++;
        }
        assertEquals(53, y);
    }

}
