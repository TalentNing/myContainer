package util.function;

import java.util.Objects;

/**
 * Created by xiaox on 2016/10/28.
 */
public interface Consumer<T> {

    void accept(T t);

//    void notaccept(T t);

    default Consumer<T> andThen(Consumer<? super T> after){
        Objects.requireNonNull(after);
        return (T t)->{accept(t);after.accept(t);};//接受一个参数t,返回
    }
}
