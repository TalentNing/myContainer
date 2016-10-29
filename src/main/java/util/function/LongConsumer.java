package util.function;

import java.util.Objects;

/**
 * Created by tkn on 2016/10/29.
 */
public interface LongConsumer {
    void accept(long value);

    default LongConsumer andThen(LongConsumer after){
        Objects.requireNonNull(after);
        return (long t)->{accept(t); after.accept(t);};//相当于new了intconsumer的一个匿名类
    }
}
