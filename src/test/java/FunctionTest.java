import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {
    @Test
    public void functionTest() {
        List<Integer> list = map(
                new ArrayList<>(Arrays.asList("ABC", "A", "AAAAA")),
                String::length
        );

        System.out.println(list);
    }

    public <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();

        for(T each : list) {
            result.add(function.apply(each));
        }
        return result;
    }

}
