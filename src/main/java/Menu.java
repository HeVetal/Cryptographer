
public class Menu {
    public static void main(String[] args) {
        while (true) {
            Util.writeMessage("""
                    Для выбора действия, выберете его номер\s
                    1. Зашифровать текст\s
                    2. Дешифровать текст\s
                    3. Подобрать ключ\s
                    4. Сентаксичекский анализ\s
                    5. Выйти из программы""");

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