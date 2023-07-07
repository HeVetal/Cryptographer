import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Encrypted {
    private CaesarCipher caesarCipher = new CaesarCipher();
    public void encrypted(){
        System.out.println("Введите путь к файлу для его зашифровки");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Введите ключ");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println("Ведите путь куда записать файл");
        String path2 = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter(path2))){
            while (reader.ready()) {
                String str = reader.readLine();
                String encrypted = caesarCipher.encrypt(str, key);
                writer.write(encrypted + "\n");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Содержимое файла зашифровано");


    }
}
