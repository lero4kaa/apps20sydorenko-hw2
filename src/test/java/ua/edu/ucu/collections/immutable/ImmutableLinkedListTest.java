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


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllLargeIndex() {
        Object[] arr = {8, 9, 9};
        testImmutableLinked.addAll(100, arr);
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllSmallIndex() {
        Object[] arr = {8, 9, 9};
        testImmutableLinked.addAll(-2, arr);
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
    public void testAddIndex0() {
        Object[] expectedArr = {8, 1, 2, 3, 4, 5};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.add(0, 8);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddLargeIndex() {
        testImmutableLinked.add(100, 8);
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddSmallIndex() {
        testImmutableLinked.add(-2, 8);
    }
    @Test
    public void testAdd() {
        Object[] expectedArr = {1, 2, 3, 4, 5, 8};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.add(8);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetLargeIndex() {
        testImmutableLinked.get(100);
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetSmallIndex() {
        testImmutableLinked.get(-2);
    }
    @Test
    public void testGet() {
        int expected = 1;
        assertEquals(expected, testImmutableLinked.get(0));
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

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeSmallIndex() {
        testImmutableLinked.remove(-2);
    }

    @Test
    public void set() {
        Object[] expectedArr = {1,2,8,4,5};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.set(2,8);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }

    @Test
    public void setIndex0() {
        Object[] expectedArr = {8,2,3,4,5};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.set(0,8);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }

    @Test
    public void setIndexLast() {
        Object[] expectedArr = {1,2,3,4,8};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.set(4,8);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetLargeIndex() {
        ImmutableList checkedIm = testImmutableLinked.set(200, 200);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetSmallIndex() {
        ImmutableList checkedIm = testImmutableLinked.set(-200, 200);
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

    @Test
    public void testAddFirst () {
        Object[] expectedArr = {10,1,2,3,4,5};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.addFirst(10);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }

    @Test
    public void testAddLast () {
        Object[] expectedArr = {1,2,3,4,5,10};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.addLast(10);
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }
    @Test
    public void testGetFirst () {
        Object expected = generalTestArr[0];
        assertEquals(expected, testImmutableLinked.getFirst());
    }
    @Test
    public void testGetLast () {
        Object expected = generalTestArr[generalTestArr.length-1];
        assertEquals(expected, testImmutableLinked.getLast());
    }
    @Test
    public void testRemoveFirst () {
        Object[] expectedArr = {2,3,4,5};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.removeFirst();
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }
    @Test
    public void testRemoveLast () {
        Object[] expectedArr = {1,2,3,4};
        ImmutableLinkedList expectedIm = new ImmutableLinkedList(expectedArr);
        ImmutableList actualIm = testImmutableLinked.removeLast();
        assertArrayEquals(expectedIm.toArray(), actualIm.toArray());
    }
    @Test
    public void testToString() {
        String expected = "1,2,3,4,5";
        assertEquals(expected, testImmutableLinked.toString());
    }
    @Test
    public void testToStringEmpty() {
        String expected = "";
        ImmutableLinkedList emptyList = new ImmutableLinkedList();
        assertEquals(expected, emptyList.toString());
    }
}
