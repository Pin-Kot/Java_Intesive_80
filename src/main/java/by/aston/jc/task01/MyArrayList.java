package by.aston.jc.task01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Resizable-array implementation of the MyList interface
 *
 * @param <E> the Type of elements in this list
 * @author Konstantin Pingol
 */
public class MyArrayList<E> implements MyList<E> {

    private E[] elements;
    private int size;
    private final int INITIAL_CAPACITY = 10;
    private final int FACTOR = 2;


    /**
     * Constructs an empty list with an initial capacity of capacity.
     *
     * @param capacity the initial capacity of the list
     * @throws IllegalArgumentException - if the specified initial capacity is wrong
     */
    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <=0");
        } else {
            this.elements = (E[]) new Object[capacity];
        }
    }


    /**
     * Constructs an empty list with an initial capacity of DEFAULT_CAPACITY.
     */
    public MyArrayList() {
        this.elements = (E[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return {@code true}
     */
    @Override
    public boolean add(E e) {
        ensureCapacity();
        elements[size++] = e;
        return true;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left.
     *
     * @param index - of the element to be removed
     * @throws IndexOutOfBoundsException - if index is wrong
     */
    @Override
    public void delete(int index) {
        checkBounds(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    /**
     * Returns the element at the position in this list.
     *
     * @param index - of the element to be received
     * @return - the element at the position in this list
     * @throws IndexOutOfBoundsException - if index is wrong
     */
    @Override
    public E get(int index) {
        checkBounds(index);
        return elements[index];
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return - the number of elements in this list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Replacing the element with another
     *
     * @param index – index of the element
     * @param e     - new element
     */
    @Override
    public void update(int index, E e) {
        checkBounds(index);
        elements[index] = e;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    /**
     * Sorts the list according to the order induced by the comparator.
     *
     * @param comparator - used to compare list elements
     * @throws NullPointerException - if the list contains (@Code null) elements
     */
    public void quickSort(Comparator<? super E> comparator) {
        quickSort(0, size - 1, comparator);
    }

    /**
     * Realisation of QuickSort.
     *
     * @param low        - bound of array
     * @param high       - bound of array
     * @param comparator - used to compare list elements
     * @throws NullPointerException - if the list contains (@Code null) elements
     */
    private void quickSort(int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quickSort(low, pivotIndex - 1, comparator);
            quickSort(pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Rearranging the elements in the array (or list) such
     * that all elements less than or equal to a chosen "pivot"
     * element are on one side, and all elements greater than
     * the pivot are on the other side
     *
     * @param low        - bound of array
     * @param high       - bound of array
     * @param comparator - used to compare list elements
     * @throws NullPointerException - if the list contains (@Code null) elements
     */
    private int partition(int low, int high, Comparator<? super E> comparator) {
        E pivot = get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    /**
     * Swapping two elements
     *
     * @param i - first element
     * @param j - second element
     */
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = (E) temp;
    }

    /**
     * Check if the index in bounds of the list
     *
     * @param index – index of the element to check bounds
     */
    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Resize base array.
     * Create the new array with new capacity. Copy all elements to the new array.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * FACTOR);
        }
    }

    /**
     * Converting list to string
     *
     * @return the string of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
