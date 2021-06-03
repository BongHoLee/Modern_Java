package methodReferTest;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class MethodReferenceTest {

    @Test
    public void methodReferTest() {
        Temp temp = new Temp();
        String s = "AA";

        Func func = Temp::longerThanOne;
        Predicate<String> pre = temp::longerThanOne;


    }



}
