package lang;

/**
 * Created by xiaox on 2016/10/28.
 */
public interface Iterable <T>{
    /**
     * @return an iterator
     */
    Iterator<T> iterator();

    default void forEach(Consumer<? super T> action)
}
