package PostRepository;

import com.github.javafaker.Faker;
import org.apache.lucene.document.Document;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DocumentFactoryTest {

    Faker faker = new Faker();

    @Test
    public void shouldCreateDocumentBasedOnPost() throws Exception {
        String postContent = faker.lordOfTheRings().location();
        String postTag = faker.artist().name();

        Post post = new Post(postContent, postTag);
        DocumentFactory documentFactory = new DocumentFactory();

        Document document = documentFactory.createDocument(post);

        assertThat(document.get("content"), equalTo(postContent));
        assertThat(document.get("tag"), equalTo(postTag));
    }
}
