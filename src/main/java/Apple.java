import java.util.ArrayList;
import java.util.List;

public class Apple {
    private String color;
    private int weight;
    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static boolean isGreenApple(Apple apple) {
        return apple.getColor().equals("GREEN");
    }

    public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, PrettyPrint print) {
        for (Apple apple : inventory) {
            String printed = print.prettyPrint(apple);
            System.out.println(printed);
        }
    }
}
