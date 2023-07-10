import java.io.*;
import java.util.Scanner;

public class EncryptedDecrypted {
    private boolean flag = false;

    public EncryptedDecrypted(boolean flag) {
        this.flag = flag;
    }

    private CaesarCipher caesarCipher = new CaesarCipher();

    public void encryptedDecrypted() {
        if (flag) {
            System.out.println("Введите путь к файлу для его зашифровки");
        } else {
            System.out.println("Введите путь к файлу для его расшифровки");
        }
        String path = Util.readerString();
        System.out.println("Введите ключ");
        int key = Integer.parseInt(Util.readerString());
        System.out.println("Ведите путь куда записать файл");
        String path2 = Util.readerString();

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(path2))) {
            while (reader.ready()) {
                String str = reader.readLine();
                if (flag) {
                    String encrypted = caesarCipher.encrypt(str, key);
                    writer.write(encrypted + "\n");
                } else {
                    String decrypted = caesarCipher.decrypt(str, key);
                    writer.write(decrypted + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (flag) {
            System.out.println("Содержимое файла зашифровано");
        } else {
            System.out.println("Содержимое файла расшифровано");
        }
    }

}
