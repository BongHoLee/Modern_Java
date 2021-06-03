public class PrintSizeAndColor implements PrettyPrint {
    @Override
    public String prettyPrint(Apple apple) {
        return "size : " + apple.getWeight() + " | color : " + apple.getColor();
    }
}
