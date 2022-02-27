package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        App.main(new String[]{});
        assertTrue( true );
    }

    @Test
    public void parseTopNews() throws IOException
    {
        App app = new App();
        app.parseWiki();
    }
}
