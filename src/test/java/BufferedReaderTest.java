import BufferedReaderPkg.BufferedReaderProcessor;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BufferedReaderTest {

    @Test
    public void bufferedTest() throws IOException {
        BufferedReaderProcessor<String, BufferedReader> p1 = new BufferedReaderProcessor<String, BufferedReader>() {
            @Override
            public String process(BufferedReader reader) throws IOException {
                return reader.readLine();
            }
        };

        BufferedReaderProcessor<String, BufferedReader> p2 = (BufferedReader br) -> br.readLine() + br.readLine();

        processFile(p1);
        processFile(p2);
        processFile((BufferedReader br) -> br.readLine() + " read!!");
    }


    public String processFile(BufferedReaderProcessor<String, BufferedReader> processor) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(br);
        }
    }
}
