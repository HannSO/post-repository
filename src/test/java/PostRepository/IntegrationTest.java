package PostRepository;

import com.github.javafaker.Faker;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class IntegrationTest {

    private Faker faker = new Faker();
    private Directory index = new RAMDirectory();
    private StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);
    private IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);
    private IndexWriter writer = new IndexWriter(index, config);
    private DocumentFactory documentFactory = new DocumentFactory();
    private PostRepository repository = new PostRepository(writer);
    private PostQuerier querier = new PostQuerier(index, analyzer);

    public IntegrationTest() throws IOException {
    }


    @Test
    public void queryingByTagShouldReturnCorrectPosts() throws Exception {
       String content = faker.lordOfTheRings().location();
       String tag = faker.artist().name();
       Post post = new Post(content, tag);


       Document document = documentFactory.createDocument(content, tag);
       Document documentTwo = documentFactory.createDocument(content, tag);

       repository.addPost(document);
       repository.addPost(documentTwo);
       writer.close();
       ArrayList<Post> posts =  querier.queryByTag(tag);

       assertThat(posts.get(0), equalTo(post));
    }

}