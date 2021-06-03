package InitReferenceTest;

import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class InitReferTest {

    static Map<String, BiFunction<Integer, String, Fruit>> fruitBox = new HashMap<>();

    static {
        fruitBox.put("apple", Apple::new);
        fruitBox.put("orange", Orange::new);
    }

    @Test
    public void initReferMap() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 9, 2, 3));

        Fruit apple = fruitBox.get("apple").apply(100, "red");
        Fruit orange = fruitBox.get("orange").apply(100, "green");

        Fruit apple2 = giveMeFruit("apple", "yellow", 100);
        Fruit orange2 = giveMeFruit("orange", "white", 500);

    }

    public List<Fruit> map(List<Integer> weights, Function<Integer, Fruit> func) {
        List<Fruit> result = new ArrayList<>();

        for(Integer weight : weights) {
            result.add(func.apply(weight));
        }

        return result;
    }

    public Fruit giveMeFruit(String fruitName, String color, int weight) {
        return fruitBox.get(fruitName).apply(weight, color);
    }



}
