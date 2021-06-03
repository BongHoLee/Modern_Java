import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("Green", 100));
        apples.add(new Apple("Green", 159));
        apples.add(new Apple("RED", 20));
        apples.add(new Apple("YELLOW", 300));
        apples.add(new Apple("RED", 10));
        apples.add(new Apple("Green", 60));

        filterApples(apples, Main::isGreenApple);
        filterApples(apples, Main::isHeavyApple);

    }

    static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : apples) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }



    // java 8 이전의 hidden files 필터링 코드
    void useFileFilter() {
        File[] files = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
    }

    // java 8 이후 메서드 참조를 이용한 간소화 가능
    void afterJava8() {
        File[] files = new File(".").listFiles(File::isHidden);
    }
}
