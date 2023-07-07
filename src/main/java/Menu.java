import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Для выбора действия, выберете его номер \n" +
                    "1. Зашифровать текст \n" +
                    "2. Дешифровать текст \n" +
                    "3. Подобрать ключ \n" +
                    "4. Сентаксичекский анализ \n" +
                    "5. Выйти из программы");

            String answer = scanner.nextLine();
            switch (answer){
                case "1" -> new Encrypted().encrypted();
                case "2" -> new Decrypted().decrypted();
                case "3" -> System.out.println("Подобрать ключ");
                case "4" -> System.out.println("Сентаксичекский анализ");
                case "5" -> {
                    return;
                }
            }
        }
    }
}