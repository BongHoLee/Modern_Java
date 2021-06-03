public class PrintLargeOrSmall implements PrettyPrint {
    @Override
    public String prettyPrint(Apple apple) {
        if (apple.getWeight() > 100)
            return "Large Size";
        else
            return "Small Size";
    }
}
