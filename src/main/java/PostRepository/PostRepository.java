package PostRepository;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;

import java.io.IOException;

public class PostRepository {

    private IndexWriter writer;

    public PostRepository(IndexWriter writer) {
        this.writer = writer;
    }

    public void addPost(Document doc) throws IOException {
        writer.addDocument(doc);
    }
}
