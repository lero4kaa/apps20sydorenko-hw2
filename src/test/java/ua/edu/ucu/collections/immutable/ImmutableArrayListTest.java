package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private Object[] generalTestArr = {1, 2, 3, 4, 5};
    ImmutableArrayList testImmutable = new ImmutableArrayList(generalTestArr);

    private Object[] expectedArr1 = {1, 2, 8, 8, 9, 3, 4, 5};
    ImmutableArrayList expectedImmutable1 = new ImmutableArrayList(expectedArr1);

    private Object[] argumentArr = {8, 8, 9};

    private int arg = 9;


    @Test
    public void testAddAllIndex() {
        ImmutableList checkedIm = testImmutable.addAll(2, argumentArr);
        assertArrayEquals(checkedIm.toArray(), expectedImmutable1.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllLargeIndex() {
        ImmutableList checkedExceptionIm = testImmutable.addAll(8, argumentArr);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllSmallIndex() {
        ImmutableList checkedExceptionIm = testImmutable.addAll(-8, argumentArr);
    }

    @Test
    public void testAddAll() {
        Object[] expectedArr = {1, 2, 3, 4, 5, 8, 8, 9};
        ImmutableArrayList expectedImmutable = new ImmutableArrayList(expectedArr);
        ImmutableList checkedIm = testImmutable.addAll(argumentArr);
        assertArrayEquals(checkedIm.toArray(), expectedImmutable.toArray());
    }

    @Test
    public void testAdd() {
        Object[] expectedArr = {1, 2, 3, 4, 5, 9};
        ImmutableArrayList expectedImmutable = new ImmutableArrayList(expectedArr);
        ImmutableList checkedIm = testImmutable.add(arg);
        assertArrayEquals(checkedIm.toArray(), expectedImmutable.toArray());
    }

    @Test
    public void testAddIndex() {
        Object[] expectedArr = {1, 2, 9, 3, 4, 5};
        ImmutableArrayList expectedImmutable = new ImmutableArrayList(expectedArr);
        ImmutableList checkedIm = testImmutable.add(2, arg);
        assertArrayEquals(checkedIm.toArray(), expectedImmutable.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddLargeIndex() {
        ImmutableList checkedIm = testImmutable.add(200, arg);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddSmallIndex() {
        ImmutableList checkedIm = testImmutable.add(-200, arg);
    }

    @Test
    public void testGet() {
        int index = 2;
        int element = 3;
        assertEquals(element, testImmutable.get(index));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetLargeIndex() {
        int index = 200;
        testImmutable.get(index);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetSmallIndex() {
        int index = -200;
        testImmutable.get(index);
    }

    @Test
    public void testRemove() {
        Object[] expectedArr = {1, 2, 4, 5};
        ImmutableArrayList expectedImmutable = new ImmutableArrayList(expectedArr);
        ImmutableList checkedIm = testImmutable.remove(2);
        assertArrayEquals(checkedIm.toArray(), expectedImmutable.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveLargeIndex() {
        ImmutableList checkedIm = testImmutable.remove(200);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveSmallIndex() {
        ImmutableList checkedIm = testImmutable.remove(-200);
    }

    @Test
    public void testSet() {
        Object[] expectedArr = {1, 2, 300, 4, 5};
        ImmutableArrayList expectedImmutable = new ImmutableArrayList(expectedArr);
        ImmutableList checkedIm = testImmutable.set(2, 300);
        assertArrayEquals(checkedIm.toArray(), expectedImmutable.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetLargeIndex() {
        ImmutableList checkedIm = testImmutable.set(200, 200);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetSmallIndex() {
        ImmutableList checkedIm = testImmutable.set(-200, 200);
    }

    @Test
    public void testIndexOf() {
        int expected = 4;
        int actual = testImmutable.indexOf(5);
        assertEquals(expected, actual);
    }
    @Test
    public void testIndexOfAbsent() {
        int actualIndex = testImmutable.indexOf(20);
        assertEquals(-1, actualIndex);
    }

    @Test
    public void testSize() {
        int expected = 5;
        int actual = testImmutable.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testClear() {
        ImmutableArrayList expectedImmutable = new ImmutableArrayList();
        ImmutableList checkedIm = testImmutable.clear();
        assertArrayEquals(checkedIm.toArray(), expectedImmutable.toArray());
    }

    @Test
    public void testIsEmptyF() {
        assertEquals(false, testImmutable.isEmpty());
    }

    @Test
    public void testIsEmptyT() {
        ImmutableList checkedIm = new ImmutableArrayList();
        assertEquals(true, checkedIm.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(generalTestArr, testImmutable.toArray());
    }

    @Test
    public void testToString() {
        String expected = "1,2,3,4,5";
        assertEquals(expected, testImmutable.toString());
    }

    @Test
    public void testToStringEmpty() {
        String expected = "";
        ImmutableArrayList emptyList = new ImmutableArrayList();
        assertEquals(expected, emptyList.toString());
    }
}
