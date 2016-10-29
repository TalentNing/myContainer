package util;

import java.util.Iterator;

/**
 * Created by tkn on 2016/10/29.
 */
public interface List <E> extends Collection<E>{

    boolean add(E e);

    void add(int index,E e);

    boolean addAll(Collection<? extends E> c);

    boolean addAll(int index,Collection<? extends E> c);

    void clear();

    boolean contains(Object o);

    boolean contains(Collection<?> c);

    boolean equals(Object o);

    E get(int index);

    int hashCode();

    int indexOf(Object o);

    boolean isEmpty();

    Iterator iterator();

    int lastIndexOf(Object o);

//    ListIterator<E> listIterator();

//  ListIterator<E> listIterator(int index);

    E remove(int index);

    boolean remove(Object o);

    boolean removeAll(Collection<?> c);

//    deafault void replaceAll(UnaryOperator<E> operator){
//
//    }

    boolean retainAll(Collection<?> c);

    E set(int index,E e);

    int size();

//    default void sort(Comparator<? super E> c ){}

//    default Spliterator<E> spliterator(){}

    List<E> subList(int fromIndex,int toIndex);

    Object[] toArray();

    <T> T[] toArray(T[] a);

}
