package PostRepository;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;

public class DocumentFactory {

    public Document createDocument(String content, String tag) {
        Document document = new Document();
        document.add(new StringField("content", content, Field.Store.YES));
        document.add(new StringField("tag", tag, Field.Store.YES));
        return document;
    }
}
