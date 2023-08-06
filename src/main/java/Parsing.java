import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        Path path = Util.builderFileName(pathEncrypted, "_pars");
        Map<Character, Integer> mapEncrypted = getFillMap(pathEncrypted);
        Map<Character, Integer> mapStatic = getFillMap(pathStatistic);
        List<Map.Entry<Character, Integer>> listEncrypted = mapToList(mapEncrypted);
        List<Map.Entry<Character, Integer>> listStatic = mapToList(mapStatic);
        Map<Character, Character> decrypted = new HashMap<>();
        if (listEncrypted.size() <= listStatic.size()) {
            for (int i = 0; i < listEncrypted.size(); i++) {
                decrypted.put(listEncrypted.get(i).getKey(), listStatic.get(i).getKey());
            }
        } else {
            Util.writeMessage("Размер файла статистики недостаточен, нужен файл большей размерности");
        }
        try (BufferedReader reader = Files.newBufferedReader(Path.of(pathEncrypted));
             BufferedWriter writer = Files.newBufferedWriter(path)) {

            while (reader.ready()) {
                StringBuilder builder = new StringBuilder();
                String line = reader.readLine();
                for (int i = 0; i < line.length(); i++) {
                    Character ch = decrypted.get(line.charAt(i));
                    builder.append(ch);
                }
                writer.write(builder.toString() + System.lineSeparator());
            }

        }
        Util.writeMessage("Файл расшиврован и находится по адресу " + path);

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
//                if (!map.containsKey(aChar)) {
//                    map.put(aChar, 1);
//                } else {
//                    map.put(aChar, map.get(aChar) + 1);
//                }
                map.merge(aChar, 1, Integer::sum);
            }

        }
        return map;
    }

    private List<Map.Entry<Character, Integer>> mapToList(Map<Character, Integer> map) {
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);

        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        list.sort(comparator);
        return list;
    }
}