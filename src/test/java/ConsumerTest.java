import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    @Test
    public void consumerTest() {
        List<String> stringList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Consumer<String> consumer = System.out::println;

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3));

        forEach(stringList, consumer);
        forEach(integerList, (Integer i) -> System.out.println(i+i));


    }

    public <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T each : list) {
            consumer.accept(each);
        }
    }
}
