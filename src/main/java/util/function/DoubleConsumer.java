package util.function;

import java.util.Objects;

/**
 * Created by tkn on 2016/10/29.
 */
public interface DoubleConsumer {
    void accept(double value);

    default DoubleConsumer andThen(DoubleConsumer after){
        Objects.requireNonNull(after);
        return (double t)->{accept(t); after.accept(t);};//相当于new了intconsumer的一个匿名类
    }
}
