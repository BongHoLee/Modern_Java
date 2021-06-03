package InitReferenceTest;

public class Apple implements Fruit{
    private int weight;
    private String color;

    public Apple(){}
    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(String color, int weight) {
        this(weight, color);
    }

    public Apple(int weight) {
        this(weight, "");
    }
    public Apple(String color) {
        this(0, color);
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getColor() {
        return color;
    }
}
