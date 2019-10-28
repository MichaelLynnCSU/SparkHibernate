package edu.csu2017fa314.T30.Model;
import static org.junit.Assert.*;

import edu.csu2017fa314.T30.Model.Itinerary.Data.Data;
import org.junit.Before;
import org.junit.Test;


public class TestModel 
{
    private Data m;

    @Before
    public void setUp() throws Exception 
    {
        m = new Data();
    }

    @Test 
    public void testGetNumbers() 
    {
        assertArrayEquals(m.getNumbers(), new int[] {0, 1, 2, 3, 4, 5});
    }

}
