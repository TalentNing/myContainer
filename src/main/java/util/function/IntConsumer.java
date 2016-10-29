package util.function;

import java.util.Objects;

/**
 * Created by tkn on 2016/10/29.
 */
public interface IntConsumer {

    void accept(int value);

    default IntConsumer andThen(IntConsumer after){
        Objects.requireNonNull(after);
        return (int t)->{accept(t); after.accept(t);};//相当于new了intconsumer的一个匿名类
    }
}
