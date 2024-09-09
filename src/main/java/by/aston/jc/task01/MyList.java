package by.aston.jc.task01;

import java.util.Comparator;

/**
 * An ordered collection
 *
 * @param <E> the Type of elements in this list
 * @author Konstantin Pingol
 */
public interface MyList<E> {

    /**
     * Appends the specified element to the end of this list
     * @param e element to be appended to this list
     * @return  {@code true}
     */
    boolean add(E e);

    /**
     * Removes the element at the specified position in this list.
     *
     * @param  index - of the element to be removed
     */
    void delete(int index);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return
     * @return the element at the specified position in this list
     */
    E get(int index);

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    int size();

    /**
     * Replacing the element with another
     *
     * @param index – index of the element
     * @param e     - new element
     */
    void update(int index, E e);

    /**
     * Removes all of the elements from this list
     */
    void clear();

    /**
     * Sorts the list according to the order induced by the comparator.
     *
     * @param comparator - used to compare list elements
     */
    void quickSort(Comparator<? super E> comparator);
}
