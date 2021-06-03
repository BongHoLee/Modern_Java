package ch4.streamBasic;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Ch4DishTest {

    private List<Dish> menu = new ArrayList<>();
    private List<Dish> specialMenu = new ArrayList<>();

    @Before
    public void setMenu() {
        menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT ),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );
    }

    @Test
    public void threeHighCaloricTest() {
        List<String> threeHighCalorieDishNames = menu.stream()
                .filter(eachDish -> eachDish.getCalories() > 500)
                .limit(3)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(threeHighCalorieDishNames);
    }

    @Test
    public void predicateFiltering() {

        List<Dish> vegi = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
    }

    @Test
    public void distinctFiltering() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 4, 6, 2, 8, 10);

        List<Integer> distinct = numbers.stream()
                .filter(number -> number % 2 == 0)
                .distinct()
                .collect(Collectors.toList());

    }

    @Test
    public void takeWhileSlicing() {
        List<Dish> takeWhileMenu = menu.stream()
                .sorted(Comparator.comparing(Dish::getCalories))
                .takeWhile(dish -> {
                    System.out.println(dish + " : " + dish.getCalories());
                    return dish.getCalories() < 300;
                }).collect(Collectors.toList());

        System.out.println(takeWhileMenu);
    }

    @Test
    public void dropWhileSlicing() {
        List<Dish> dropWhileMenu = menu.stream()
                .sorted(Comparator.comparing(Dish::getCalories))
                .dropWhile(dish -> dish.getCalories() < 300)
                .collect(Collectors.toList());

        System.out.println(dropWhileMenu);
    }

    @Test
    public void limitSlicing() {
        List<Dish> limitedMenu = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(limitedMenu);
    }

    @Test
    public void skipSlicing() {
        List<Dish> skipMenu = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());

        System.out.println(skipMenu);
    }

    @Test
    public void quiz5_1() {
        List<Dish> dishes = menu.stream()
                .filter(dish -> Dish.Type.MEAT == dish.getType())
                .limit(2)
                .collect(Collectors.toList());

        dishes.forEach(dish -> {
            assertThat(dish.getType(), is(equalTo(Dish.Type.MEAT)));
        });

    }

    @Test
    public void mapTest() {
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

        List<Integer> wordLen = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(wordLen);
    }

    @Test
    public void flatMapTest() {
        List<String> words = Arrays.asList("Hello", "World");

        // want to ["H", "E", "L", "L", "O", "W", "O", "R", "L", "D"]

        List<String> flatted1 =words.stream()
                .flatMap(eachWord -> Arrays.stream(eachWord.split("")))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(flatted1);

        List<String> flatted2 = words.stream()
                .map(eachWord -> eachWord.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(flatted2);
    }

    @Test
    public void quiz5_2_1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squares = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());

        System.out.println(squares);
    }

    @Test
    public void quiz5_2_2() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);

          List<List<Integer>> result = list1.stream()
                  .flatMap(num1 -> list2.stream().filter(num2 -> (num1+num2)%3 == 0).map(num2 -> Arrays.asList(num1, num2)))
                  .collect(Collectors.toList());

        System.out.println(result);




    }
}
