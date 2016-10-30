package util;

import java.util.*;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

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

    boolean containsAll(Collection<?> c);

    boolean equals(Object o);

    E get(int index);

    int hashCode();

    int indexOf(Object o);

    boolean isEmpty();

    Iterator iterator();

    int lastIndexOf(Object o);

    ListIterator<E> listIterator();   // I do not know how to implement a iterator

    ListIterator<E> listIterator(int index);

    E remove(int index);

    boolean remove(Object o);

    boolean removeAll(Collection<?> c);

    default void replaceAll(UnaryOperator<E> operator){
        Objects.requireNonNull(operator);
        ListIterator<E> listIter = this.listIterator();
        while(listIter.hasNext()){
            listIter.set(operator.apply(listIter.next()));
        }
    }

    boolean retainAll(Collection<?> c);

    E set(int index,E e);

    int size();

    default void sort(Comparator<? super E> c ){
        Object[] o = this.toArray();
        Arrays.sort(o,(Comparator<Object>)c);
        ListIterator iter = listIterator();
        for(Object ob : o){
            iter.next();
            iter.set(ob);
        }
    }

//    default Spliterator<E> spliterator(){
//
//    }

    List<E> subList(int fromIndex,int toIndex);

    Object[] toArray();

    <T> T[] toArray(T[] a);

}
