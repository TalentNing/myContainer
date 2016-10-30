import java.util.Spliterator;
import java.util.Spliterators;

/**
 * Created by tkn on 2016/10/29.
 */
interface inter{
    public void print(String param);
}
public class Test {

    public void f() {
        throw new RuntimeException();
    }


    public static void main(String[] args) {
        int[] ss = new int[2];
        int i = 0;
        ss[i++] = 5;
        System.out.println(ss[0]);
    }
}
