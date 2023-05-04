package net.homecredit.clazz;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple IAmGood.
 */
public class IAmGoodTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public IAmGoodTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( IAmGoodTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        final String args[] = {"I can test main method in Java"};

        final PrintStream original = System.out;

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		IAmGood.main(args);

		assertEquals(args[0], os.toString().trim());

		System.setOut(original);
    }
}
