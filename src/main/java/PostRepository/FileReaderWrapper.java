package PostRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileReaderWrapper {
    public String parse(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            String fullText = "";
            while ((line = br.readLine()) != null) {
                System.out.println("line is : " + line);
                fullText = fullText + "/n" + line;
            }
            return fullText;
        }
    }

}
