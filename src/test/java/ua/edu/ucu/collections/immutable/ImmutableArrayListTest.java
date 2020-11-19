package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private Object[] generalTestArr = {1,2,3,4,5};
    ImmutableArrayList testImmutable = new ImmutableArrayList(generalTestArr);

    private Object[] expected = {1,2,8,8,9,3,4,5};
    ImmutableArrayList expectedImmutable = new ImmutableArrayList(expected);

    @Test
    public void testSomeMethod() {
    }

    @Test
    public void testAddAll() {
        Object[] arr = {8, 8, 9};
        ImmutableList newIm = testImmutable.addAll(2, arr);
        boolean expected = true;
        boolean actual;
        actual = newIm.checkEquals(expectedImmutable);
        assertEquals(expected, actual);
    }
    
}
