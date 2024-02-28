package ru.aston.hw002;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayList<T> {

    private final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] myArray = new Object[DEFAULT_CAPACITY];

    public MyArrayList() {
    }


    private void reSize() {
        int i = (int) (this.myArray.length * 1.5);
        Object[] tempArray = new Object[i];
        System.arraycopy(myArray, 0, tempArray, 0, size);
        myArray = tempArray;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkOfCorrectIndex(index, size);
        return (T) myArray[index];
    }

    public void add(int index, T element) {
        checkOfCorrectIndex(index, size);
        if (size == myArray.length) {
            reSize();
        }
        System.arraycopy(myArray, index, myArray, index + 1, myArray.length - index - 1);
        myArray[index] = element;

        size++;

    }

    public void addAll(Collection<? extends T> c) {
        while (myArray.length - size < c.size()) {
            reSize();
        }
        for (T elem : c) {
            add(size, elem);
        }
    }

    public void clear() {
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        checkOfCorrectIndex(index, size);
        System.arraycopy(myArray, 0, myArray, 0, index);
        System.arraycopy(myArray, index + 1, myArray, index, myArray.length - index - 1);
        size--;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(myArray[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super T> comparator) {
        if (size > 1) {
            T[] tempArray = Arrays.copyOf((T[]) myArray, size);
            quickSort(comparator, tempArray, 0, size - 1);
            myArray = Arrays.copyOf(tempArray, size);
        }
    }

    private void quickSort(Comparator<? super T> comparator, T[] array, int low, int high) {
        if (low < high) {
            int index = partition(array, low, high, comparator);
            quickSort(comparator, array, low, index - 1);
            quickSort(comparator, array, index + 1, high);
        }
    }

    private int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
        T highElem = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], highElem) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private void checkOfCorrectIndex(int index, int size) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return "Size: " + size + " Capacity: "
                + myArray.length + " " + Arrays.toString(myArray);
    }
}