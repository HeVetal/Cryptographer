import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class EncryptedDecrypted {

    private final CaesarCipher caesarCipher = new CaesarCipher();

    @SneakyThrows
    public void encryptedDecrypted(boolean flag) {

        Util.writeMessage("Введите путь к файлу для его " + (flag ? "зашифровки" : "расшифровки"));
        String path = Util.readerString();
        Util.writeMessage("Введите ключ");
        int key = Util.readInt();
        Path dest = Util.builderFileName(path, flag ? "_encrypted" : "_decrypted");
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
             BufferedWriter writer = Files.newBufferedWriter(dest)) {
            while (reader.ready()) {
                String str = reader.readLine();
                String encryptedDecrypted = flag ? caesarCipher.encrypt(str, key) : caesarCipher.decrypt(str, key);
                writer.write(encryptedDecrypted);
                writer.newLine();
            }
        }
        Util.writeMessage("Содержимое файла " + (flag ? "зашифровано" : "расшифровано"));
    }
}
