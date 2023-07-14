import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Parsing {
    
    @SneakyThrows
    public void parse(){
        Util.writeMessage("Введите путь к файлу для расшифровки");
        String pathEncrypted = Util.readerString();
        Util.writeMessage("Введите путь к файлу статистики");
        String pathStatistic = Util.readerString();
        Map<Character,Integer> map = new HashMap<>();
        try(BufferedReader reader = Files.newBufferedReader(Path.of(pathEncrypted))){
            StringBuilder builder = new StringBuilder();
            while (reader.ready()){
                builder.append(reader.readLine());
            }
            char[] charArray = builder.toString().toCharArray();
            for (int i = 0; i < charArray.length; i++) {

            }

        }
    }
}
