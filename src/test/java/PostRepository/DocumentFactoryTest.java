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
        String post = faker.artist().name();

        DocumentFactory documentFactory = new DocumentFactory();

        Document document = documentFactory.createDocument(post);

        assertThat(document.get("content"), equalTo(post));
    }
}
