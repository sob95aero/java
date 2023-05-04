package net.homecredit.clazz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlowControls_test_slide_16c {

    @Test
    public void ifThenElse() {

        final StringBuilder sb = new StringBuilder();

        int i = 0;
        for (; i < 10; i++) {
            if (i == 3) {
                sb.append("fizz");

            } else if (i == 5) {
                sb.append("buzz");
            } else {
                sb.append(i);
            }
            sb.append(" ");
        }
        assertEquals("0 1 2 fizz 4 buzz 6 7 8 9 ", sb.toString());
    }

    @Test
    public void ifElse() {

        final StringBuilder sb = new StringBuilder();

        int i = 0;
        for (; i < 10; i++) {
            if (i == 3)
                sb.append("fizz");
            if (i == 5)
                sb.append("buzz");
            else
                sb.append(i);

            sb.append(" ");
        }
        // TODO will not work.. why ?
        // assertEquals("0 1 2 fizz 4 buzz 6 7 8 9 ", sb.toString());
    }

}
