import java.io.*;
import java.util.Scanner;

public class Decrypted {
    private CaesarCipher caesarCipher = new CaesarCipher();

    public void decrypted() {
        System.out.println("Введите путь к файлу для его зашифровки");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Введите ключ");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println("Ведите путь куда записать файл");
        String path2 = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(path2))) {
            while (reader.ready()) {
                String str = reader.readLine();
                String decrypted = caesarCipher.decrypt(str, key);
                writer.write(decrypted + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Содержимое файла расшифровано");
    }
}
