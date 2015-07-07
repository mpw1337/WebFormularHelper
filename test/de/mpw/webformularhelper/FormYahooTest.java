package de.mpw.webformularhelper;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import static org.junit.Assert.assertEquals;

/**
 * Created by Markus on 07.07.2015.
 */
public class FormYahooTest {

    private FormBlueprint form;

    @Before
    public void setUp() throws Exception {
        Document d = null;
        Namen n = new Namen();
        form = new FormYahoo(d, n);
    }

    @Test
    public void testFirstName() throws Exception {
        assertEquals("first-name", form.getFIRSTNAME());
    }
}