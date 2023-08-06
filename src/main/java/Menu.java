
public class Menu {
    public static void main(String[] args) {
        while (true) {
            Util.writeMessage("Для выбора действия, выберете его номер \n" +
                    "1. Зашифровать текст \n" +
                    "2. Дешифровать текст \n" +
                    "3. Подобрать ключ \n" +
                    "4. Сентаксичекский анализ \n" +
                    "5. Выйти из программы");

            String answer = Util.readerString();
            switch (answer) {
                case "1" -> new EncryptedDecrypted().encryptedDecrypted(true);
                case "2" -> new EncryptedDecrypted().encryptedDecrypted(false);
                case "3" -> new Bruteforce().bruteforce();
                case "4" -> new Parsing().parse();
                case "5" -> {
                    return;
                }
            }
        }
    }
}