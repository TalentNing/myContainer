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
        Iterator<E> iterator = iterator();
        while(iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }

    public boolean contains(Object o ){
        Iterator<E> iterator = iterator();
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
        Iterator<E> iterator = iterator();
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
        Iterator<E> iterator = iterator();
        boolean flag = false;
        while(iterator.hasNext()){
            if(c.contains(iterator.next())){
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }

    public boolean retainAll(Collection<?> c){
        Objects.requireNonNull(c);
        Iterator<E> iterator = iterator();
        boolean flag = false;
        while(iterator.hasNext()){
            if(!c.contains(iterator.next())){
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }

    /**
     * this method returns an array that contains all the elements returned by the collection's iterator,in the
     * same order.
     * The length of the array is equal to equal to the number of elements returned by the iterator,even if the size
     * of the collection changes during iteration ,as might happened if the collection permits concurrent modification
     * during iteration.
     * @return
     */
    public Object[] toArray(){
        Object[] r = new Object[size()];
        Iterator<E> iter = iterator();
        for(int i=0;i<r.length;i++){
            if(!iter.hasNext())
                return Arrays.copyOf(r,i);//fewer elements than size()
            r[i] = iter.next();
        }
        return iter.hasNext()?finishToArray(r,iter):r;
    }

   private <T> T[] finishToArray(T[] r,Iterator<?> iter){
        int i = r.length;
       while(iter.hasNext()){
           int cap = r.length;
           if(i==cap){
               cap = cap + (cap>>1) +1;
               r = Arrays.copyOf(r,cap);
           }
            r[i++] = (T)iter.next();
       }
       return (i==r.length) ? r : Arrays.copyOf(r,i);
   }

   public <T> T[] toArray(T[] a){
       int size = size();
       T[] r = (a.length>=size) ? a : (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(),size);
       Iterator<E> iter = iterator();
       for(int i=0;i<size;i++){
            if(!iter.hasNext()){
                if(a==r){
                    a[i] = null;
                }else if(a.length<i){   //i代表r中已有元素个数
                    return Arrays.copyOf(r,i);
                }else{
                    System.arraycopy(r, 0, a, 0, i);
                    if (a.length > i) {
                        a[i] = null;
                    }
                }
                return a;
            }
            r[i] = (T)iter.next();
       }
       return iter.hasNext() ? finishToArray(r, iter) : r;
   }

   public String toString(){
       Iterator<E> iter = iterator();
       if(!iter.hasNext())
           return "[]";
       StringBuilder sb = new StringBuilder();
       sb.append('[');
       while(true){
            E e = iter.next();
           sb.append(e == this ? "(this Collection)" : e);
           if (! iter.hasNext())
               return sb.append(']').toString();
           sb.append(',').append(' ');
       }
   }

}
