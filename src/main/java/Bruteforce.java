import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bruteforce {

    private final CaesarCipher caesar = new CaesarCipher();
    private static final int MAX_LENGTH_WORD = 28;

    @SneakyThrows
    public void bruteforce() {
        Util.writeMessage("Введите путь к файлу для расшифровки");
        String path = Util.readerString();
        Path bruteforce = Util.builderFileName(path, "_bruteforce");

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
             BufferedWriter writer = Files.newBufferedWriter(bruteforce)) {
            StringBuilder builder = new StringBuilder();
            List<String> list = new ArrayList<>();
            while (reader.ready()) {
                String string = reader.readLine();
                builder.append(string).append(System.lineSeparator());
                list.add(string);
            }
            for (int i = 0; i < caesar.alphabetLength(); i++) {
                String decrypt = caesar.decrypt(builder.toString(), i);
                if (isValidateText(decrypt)) {
                    for (String string : list) {
                        String encrypt = caesar.decrypt(string, i);
                        writer.write(encrypt);
                        writer.newLine();
                    }
                    Util.writeMessage("Содержимое файла рашифровано, ключ равен " + i);
                    break;
                }
            }
        }
    }

    private boolean isValidateText(String text) {
        boolean isValidate = false;
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() > MAX_LENGTH_WORD) {
                return false;
            }
        }
        if (text.contains(", ") || text.contains(". ") || text.contains("! ") || text.contains("? ")) {
            isValidate = true;
        }
        while (isValidate) {
            int start = new Random().nextInt(text.length()/2);
            Util.writeMessage("Текст коректный? " + text.substring(start, start + (int) Math.sqrt( text.length())));
            Util.writeMessage("Если корректный текст введите Y/N");
            String answerUser = Util.readerString();
            if (answerUser.equalsIgnoreCase("Y")) {
                return true;
            } else if (answerUser.equalsIgnoreCase("N")) {
                isValidate = false;
            } else {
                Util.writeMessage("Выбор только Y/N");

            }
        }
        return false;
    }

}
