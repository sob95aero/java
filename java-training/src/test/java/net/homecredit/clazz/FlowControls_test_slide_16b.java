package net.homecredit.clazz;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;


public class FlowControls_test_slide_16b {

    @Test
    public void switchEnum() {

        // this is very very stupid example - can be written in one line - see next test

        ABILITY ability = ABILITY.MUSIC;

        String name = "";

        switch (ability) {
            case MUSIC:
                name = FAMOUS_PEOPLE.ARMSTRONG_LOUIS.name();
        }

        assertEquals(FAMOUS_PEOPLE.ARMSTRONG_LOUIS.name(), name);
    }

    @Test
    public void enumMappingMethod() {
        ABILITY ability = ABILITY.MUSIC;

        FAMOUS_PEOPLE people = FAMOUS_PEOPLE.valueFrom(ability);

        assertEquals(FAMOUS_PEOPLE.ARMSTRONG_LOUIS, people);
    }

    // TODO this test will fail sometimes but seems to be ok.. What is wrong ? :-) (and how to fix it ? )
    // solution: ;tsrif : dnoces ? renniw == tsrif = resool DNAH

    @Test
    public void rockPaperScissors() {
        HAND first = HAND.getRandom();
        HAND second = HAND.getRandom();

        HAND winner = first == second ? null : first.beats == second ? first : second;

        if (winner == null) {
            assertEquals(first, second);
            return;
        }

        switch (winner) {

            case ROCK:
                assertEquals(HAND.SCISSORS, second);
                break;
            case PAPER:
                assertEquals(HAND.ROCK, second);
                break;
            case SCISSORS:
                assertEquals(HAND.PAPER, second);
                break;
        }
    }


    public enum ABILITY {
        MUSIC
    }

    private enum FAMOUS_PEOPLE {

        ARMSTRONG_LOUIS(ABILITY.MUSIC);

        private final ABILITY knownFor;

        FAMOUS_PEOPLE(ABILITY knownFor) {
            this.knownFor = knownFor;
        }

        public static FAMOUS_PEOPLE valueFrom(ABILITY ability) {
            for (FAMOUS_PEOPLE people : values()) {
                if (people.knownFor.equals(ability))
                    return people;
            }
            return null;
        }

    }

    public enum HAND {

        ROCK, PAPER, SCISSORS;

        static final Random RANDOM = new Random();

        static {
            ROCK.beats = SCISSORS;
            PAPER.beats = ROCK;
            SCISSORS.beats = PAPER;
        }

        public HAND beats;


        public static HAND getRandom() {
            return HAND.values()[RANDOM.nextInt(values().length)];
        }
    }

}
