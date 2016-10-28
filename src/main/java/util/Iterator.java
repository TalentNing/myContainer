package util;

import util.function.Consumer;

import java.util.Objects;

/**
 * Created by xiaox on 2016/10/28.
 */
public interface Iterator<E> {
    boolean hasNext();

    E next();

    default void remove(){
        throw new UnsupportedOperationException("remove");
    }

    default void forEachRemaining(Consumer<? super E> action){
        Objects.requireNonNull(action);
        while(hasNext()){
            action.accept(next());
        }
    }

}
