package PostRepository;

public class Post {
    private String content;
    private String tag;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (content != null ? !content.equals(post.content) : post.content != null) return false;
        return tag != null ? tag.equals(post.tag) : post.tag == null;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }

    public Post(String content, String tag) {
        this.content = content;
        this.tag = tag;
    }
}
