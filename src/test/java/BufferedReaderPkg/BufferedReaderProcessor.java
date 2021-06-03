package BufferedReaderPkg;

import java.io.IOException;

public interface BufferedReaderProcessor<T, R> {
    T process(R reader) throws IOException;
}
