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
        try
        {
            String str = Files.readString(Path.of(path));
            String[] strMass = str.split("\n");
            StringBuilder var = new StringBuilder();
            for (int i = 0; i < strMass.length; i++) {
                String encryptedDecrypted = flag ? caesarCipher.encrypt(strMass[i], key) : caesarCipher.decrypt(strMass[i], key);
                encryptedDecrypted += System.lineSeparator();
                var.append(encryptedDecrypted);

            }
            Files.writeString(dest, var);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Util.writeMessage("Содержимое файла " + (flag ? "зашифровано" : "расшифровано"));
        Util.writeMessage(String.valueOf(dest));
    }
}
