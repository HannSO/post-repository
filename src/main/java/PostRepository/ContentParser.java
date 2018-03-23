package PostRepository;


public class ContentParser {
    public Post parse(String input) {
        String[] parts = input.split("#");
        return new Post(parts[0].trim(), parts[1].trim());
    }
}
