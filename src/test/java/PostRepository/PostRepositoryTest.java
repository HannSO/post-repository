package PostRepository;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PostRepositoryTest {

    @Test
    public void shouldAddDocToIndexWriter() throws Exception {
        IndexWriter writer =  mock(IndexWriter.class);
        PostRepository postRepository = new PostRepository(writer);
        Document doc = new Document();
        postRepository.addPost(doc);
        verify(writer).addDocument(doc);
    }
}