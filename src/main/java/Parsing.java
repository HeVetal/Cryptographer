import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Parsing {

    @SneakyThrows
    public void parse() {
        Util.writeMessage("Введите путь к файлу для расшифровки");
        String pathEncrypted = Util.readerString();
        Util.writeMessage("Введите путь к файлу статистики");
        String pathStatistic = Util.readerString();
        Map<Character, Integer> mapEncrypted = getFillMap(pathEncrypted);
        Map<Character, Integer> mapStatic = getFillMap(pathStatistic);
        Set<Map.Entry<Character, Integer>> entries = mapEncrypted.entrySet();
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);

    }

    @SneakyThrows
    private Map<Character, Integer> getFillMap(String path) {

        Map<Character, Integer> map = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                builder.append(reader.readLine()).append(System.lineSeparator());
            }
            for (char aChar : builder.toString().toCharArray()) {
                if (!map.containsKey(aChar)) {
                    map.put(aChar, 1);
                } else {
                    map.put(aChar, map.get(aChar) + 1);
                }
            }
        }
        return map;
    }

    private void method(Map<Character, Integer> map) {
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);

        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        list.sort(comparator);
    }
}