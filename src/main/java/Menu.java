import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Для выбора действия, выберете его номер \n" +
                    "1. Зашифровать текст \n" +
                    "2. Дешифровать текст \n" +
                    "3. Подобрать ключ \n" +
                    "4. Сентаксичекский анализ \n" +
                    "5. Выйти из программы");

            String answer = Util.readerString();
            switch (answer){
                case "1" -> new EncryptedDecrypted(true).encryptedDecrypted();
                case "2" -> new EncryptedDecrypted(false).encryptedDecrypted();
                case "3" -> System.out.println("Подобрать ключ");
                case "4" -> System.out.println("Сентаксичекский анализ");
                case "5" -> {
                    return;
                }
            }
        }
    }
}