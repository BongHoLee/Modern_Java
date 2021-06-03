import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
    @Test
    public void predicateTest() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Predicate<String> predicate = (String s) -> !s.isEmpty();

        List<String> r1 = filter(predicate, list);

        List<String> r2 = filter(s -> s.substring(0, 1).equals("A"), list);
    }

    public <T> List<T> filter(Predicate<T> predicate, List<T> inputList) {
        List<T> result = new ArrayList<>();

        for(T each : inputList) {
            if (predicate.test(each)) {
                result.add(each);
            }
        }

        return result;
    }
}


