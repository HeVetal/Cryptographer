import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EncryptedTest {
    private static final String text = "Hello world!\n" +
                                        "Hello world!";


    private CaesarCipher caesarCipher = new CaesarCipher();
    private int key = 5;

    @Test
    void encrypted() {
        try (FileWriter writer = new FileWriter("src/main/resources/test")){
            writer.write(text);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String encrypt = caesarCipher.encrypt(text, key);

    }
}