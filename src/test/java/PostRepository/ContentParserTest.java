package PostRepository;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContentParserTest {

    private String input = "Hello my name is blah blah blah blah \n #me";

    @Test
    public void shouldReturnPostWithContentAndTag() throws Exception {
        ContentParser parser = new ContentParser();
        Post expected = new Post("Hello my name is blah blah blah blah", "me");
        assertThat(parser.parse(input), equalTo(expected));
    }
}