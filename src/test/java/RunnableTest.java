import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RunnableTest {

    @Test
    public void runnableTest() {
        Runnable run1 = () -> System.out.println("HelloWorld1");
        Runnable run2 = () -> { System.out.println("HelloWorld2"); };

        Runnable run3 = new Runnable() {
            
            @Override
            public void run() {
                System.out.println("HelloWorld3");
            }
        };

        process(run1);
        process(run2);
        process(run3);
        process(() -> System.out.println("HelloWorld4"));
    }

    public void process(Runnable r) {
        r.run();
    }

}
