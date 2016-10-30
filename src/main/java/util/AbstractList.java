package util;

/**
 * Created by tkn on 2016/10/30.
 */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>{

    protected int modCount;

    protected AbstractList(){   }

    public boolean add(E e){
        add(size(),e);
        return true;
    }

    public void add(int index,E e){
        throw new UnsupportedOperationException(); //this is a runntime exception
    }


}
