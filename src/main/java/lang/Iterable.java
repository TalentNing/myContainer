package lang;

import util.Iterator;
import util.Spliterator;
import util.function.Consumer;

import java.util.Objects;


/**
 * Created by xiaox on 2016/10/28.
 */
public interface Iterable <T>{
    /**
     * @return an iterator
     */
    Iterator<T> iterator();

    default void forEach(Consumer<? super T> action){
        Objects.requireNonNull(action);
//        for(T t : this){
//            action.accept(t);
//        }
    }

    default Spliterator<T> spliterator(){
        return new Spliterator<T>() {
            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                return false;
            }

            @Override
            public Spliterator<T> trySplit() {
                return null;
            }

            @Override
            public long estimateSize() {
                return 0;
            }

            @Override
            public int characteristics() {
                return 0;
            }
        };
    }
}
