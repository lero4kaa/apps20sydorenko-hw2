package ua.edu.ucu.collections.immutable;


public class ImmutableArrayList implements ImmutableList {

    private final Object[] generalArray;
    private final int length;

    public ImmutableArrayList(Object[] values) {
        generalArray = values.clone();
        length = generalArray.length;
    }

    public ImmutableArrayList() {
        generalArray = new Object[0];
        length = 0;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        Object[] temp = {e};
        return addAll(length, temp);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        Object[] temp = {e};
        return addAll(index, temp);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(length, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (0 > index || index > length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        Object[] resultArray = new Object[length+c.length];
        System.arraycopy(generalArray, 0, resultArray, 0, index);
        System.arraycopy(c, 0, resultArray, index, c.length);
        System.arraycopy(generalArray, index, resultArray,
                  index+c.length, length - index);
        return new ImmutableArrayList(resultArray);
    }

    @Override
    public Object get(int index) {
        if (0 > index || index >= length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        return generalArray[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (0 > index || index >= length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        Object[] resultArray = new Object[length-1];
        System.arraycopy(generalArray, 0, resultArray, 0, index);
        System.arraycopy(generalArray, index+1,
                         resultArray, index, length-1-index);
        return new ImmutableArrayList(resultArray);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (0 > index || index >= length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        Object[] resultArray = new Object[length];
        System.arraycopy(generalArray, 0, resultArray, 0, index);
        resultArray[index] = e;
        System.arraycopy(generalArray, index+1, resultArray,
                  index+1, length-index-1);
        return new ImmutableArrayList(resultArray);
    }

    @Override
    public int indexOf(Object e) {
        int i = 0;
        for (Object element: generalArray) {
            if (element == e) {
                return i;
            }
            i += 1;
        }
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] resultArray = generalArray.clone();
        return resultArray;
    }

    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer();
        for (Object element: generalArray) {
            bf.append(element + ",");
        }
        if (bf.length() > 0) {
            bf.deleteCharAt(bf.length()-1);
        }
        return bf.toString();
    }
}
