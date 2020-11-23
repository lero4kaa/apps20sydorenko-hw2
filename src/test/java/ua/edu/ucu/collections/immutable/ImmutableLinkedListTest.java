package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private Object[] generalTestArr = {1, 2, 3, 4, 5};
    ImmutableLinkedList testImmutableLinked = new ImmutableLinkedList(generalTestArr);


    @Test
    public void testAddAllIndex() {
        Object[] expectedArr = {1, 2, 3, 8, 9, 9, 4, 5};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        Object[] arr = {8, 9, 9};
        ImmutableList actualIm = testImmutableLinked.addAll(3, arr);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }

    @Test
    public void testAddAllIndex0() {
        Object[] expectedArr = {8, 9, 9, 1, 2, 3, 4, 5};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        Object[] arr = {8, 9, 9};
        ImmutableList actualIm = testImmutableLinked.addAll(0, arr);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllLargeIndex() {
        Object[] arr = {8, 9, 9};
        testImmutableLinked.addAll(100, arr);
    }

    @Test
    public void testAddAll() {
        Object[] expectedArr = {1, 2, 3, 4, 5, 8, 9, 9};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        Object[] arr = {8, 9, 9};
        ImmutableList actualIm = testImmutableLinked.addAll(arr);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }

    @Test
    public void testAddIndex() {
        Object[] expectedArr = {8, 1, 2, 3, 4, 5};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.add(0, 8);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddLargeIndex() {
        testImmutableLinked.add(100, 8);
    }
    @Test
    public void testAdd() {
        Object[] expectedArr = {1, 2, 3, 4, 5, 8};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.add(8);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }
    @Test
    public void testGet() {
        int expected = 5;
        assertEquals(expected, testImmutableLinked.get(4));
    }
    @Test
    public void remove() {
        Object[] expectedArr = {1,2,4,5};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.remove(2);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeLargeIndex() {
        testImmutableLinked.remove(20);
    }

    @Test
    public void set() {
        Object[] expectedArr = {1,2,8,4,5};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.set(2,8);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }
    @Test
    public void IndexOf() {
        int actualIndex = testImmutableLinked.indexOf(2);
        int expected = 1;
        assertEquals(expected, actualIndex);
    }
    @Test
    public void IndexOfAbsent() {
        int actualIndex = testImmutableLinked.indexOf(20);
        assertEquals(-1, actualIndex);
    }
    @Test
    public void IndexOfLast() {
        int actualIndex = testImmutableLinked.indexOf(5);
        int expected = 4;
        assertEquals(expected, actualIndex);
    }
    @Test
    public void isEmptyT() {
        ImmutableLinkedList emptyImmutable = new ImmutableLinkedList();
        assertEquals(true, emptyImmutable.isEmpty());
    }
    @Test
    public void isEmptyF() {
        assertEquals(false, testImmutableLinked.isEmpty());
    }
    @Test
    public void testSize() {
        int expectedSize = 5;
        assertEquals(expectedSize, testImmutableLinked.size());
    }
    @Test
    public void testClear() {
        ImmutableLinkedList emptyImmutable = new ImmutableLinkedList();
        assertArrayEquals(emptyImmutable.toArray(),
                          testImmutableLinked.clear().toArray());
    }
    @Test
    public void testToArray () {
        assertArrayEquals(generalTestArr, testImmutableLinked.toArray());
    }
}
