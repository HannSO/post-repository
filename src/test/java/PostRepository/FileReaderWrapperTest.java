package PostRepository;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FileReaderWrapperTest {
    //TODO: change this filePath
    private String filePath = "/Users/hannahsmyth-osbourne/Projects/post-repository/src/test/java/PostRepository/InputTestFile.txt";

   private FileReaderWrapper fileReader = new FileReaderWrapper();

    @Test
    public void shouldReturnContentOfFileAsString() throws Exception {
        assertThat(fileReader.parse(filePath), equalTo("/nSomething/n/nSomething/n/n#Something"));
    }
}
