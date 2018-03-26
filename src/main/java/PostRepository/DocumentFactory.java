package PostRepository;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;

public class DocumentFactory {

    public Document createDocument(Post post) {
        Document document = new Document();
        document.add(new StringField("content", post.getContent(), Field.Store.YES));
        document.add(new StringField("tag", post.getTag(), Field.Store.YES));
        return document;
    }
}
