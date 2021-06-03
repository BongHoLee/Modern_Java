import org.junit.Test;

import java.util.function.Predicate;

public class PredicateCombination {

    @Test
    public void predicateCombTest() {
        Predicate<Apple> pre1 = apple -> apple.getWeight() > 1;
        Predicate<Apple> pre2 = pre1.negate();

        Predicate<Apple> pre3 = pre1.or(apple -> apple.getWeight() < 0).and(apple -> apple.getColor().equals("red"));

    }
}
