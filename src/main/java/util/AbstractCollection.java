package util;


import java.util.*;

/**
 * Created by tkn on 2016/10/29.
 */
public abstract class AbstractCollection<E> extends Object implements Collection<E>{

    protected AbstractCollection(){ }

    public boolean add(E e){
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> c){
       boolean flag = false;
        for(E e : c)
            if(add(e))
                flag = true;
        return flag;
    }

    public abstract java.util.Iterator<E> iterator();

    public abstract int size();

    public boolean isEmpty(){
        return size()==0;
    }

    public void clear(){
        Iterator iterator = iterator();
        while(iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }

    public boolean contains(Object o ){
        Iterator iterator = iterator();
        if(o==null){
            while(iterator.hasNext())
                if(iterator.next()==null)
                    return true;
        }else{
            while(iterator.hasNext())
                if(iterator.next().equals(o))
                    return true;
        }
        return false;
    }

    public boolean containsAll(Collection<?> c){
        for(Object o:c)
            if(!contains(o))
                return false;
        return true;
    }

    public boolean remove(Object o){
        Iterator iterator = iterator();
        if(o==null){
            while(iterator.hasNext())
                if(iterator.next()==null){
                    iterator.remove();
                    return true;
                }
        }else{
            while(iterator.hasNext())
                if(iterator.next().equals(o)){
                    iterator.remove();
                    return true;
                }
        }
        return false;
    }

    public boolean removeAll(Collection<?> c){
        Objects.requireNonNull(c);
        Iterator iterator = iterator();
        boolean flag = false;
        while(iterator.hasNext()){
            if(c.contains(iterator.next())){
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }




}
