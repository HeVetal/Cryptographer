import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Bruteforce {


    private final CaesarCipher caesar = new CaesarCipher();

    @SneakyThrows
    public void bruteforce(){
        Util.writeMessage("Введите ауть к файлу для расшифровки");
        String path = Util.readerString();
        Path bruteforce = Util.builderFileName(path, "_bruteforce");

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
             BufferedWriter writer = Files.newBufferedWriter(bruteforce))   {
            StringBuilder text = new StringBuilder();
            while (reader.ready()){
                text.append(reader.readLine());
                text.append(System.lineSeparator());
            }
            writer.write(text.toString());
        }

    }

}
