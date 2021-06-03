package InitReferenceTest;

public class Orange implements Fruit{
    private String color;
    private int weight;

    public Orange(){}
    public Orange(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Orange(String color, int weight) {
        this(weight, color);
    }

    public Orange(int weight) {
        this(weight, "");
    }
    public Orange(String color) {
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
