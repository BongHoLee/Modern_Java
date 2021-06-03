import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Test1 {

    private List<Apple> inventory;

    @Before
    public void beforeMethod() {
        inventory = new ArrayList<>(Arrays.asList(
                new Apple("GREEN", 150),
                new Apple("RED", 70),
                new Apple("YELLOW", 110),
                new Apple("GREEN", 80),
                new Apple("YELLOW", 120),
                new Apple("RED", 90)
        ));

    }

    @Test
    public void test1() {
        List<Apple> apples = filterApples(inventory, Apple::isHeavyApple);
        List<Apple> apples2 = filterApples(inventory, (Apple apple) -> apple.getColor().equals("GREEN"));
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    @Test
    public void test2() {
        List<Apple> result = Apple.filterApple(inventory, new AppleGreenColorPredicate());
    }

    @Test
    public void test3() {
        Apple.prettyPrintApple(inventory, new PrintSizeAndColor());
    }

}
