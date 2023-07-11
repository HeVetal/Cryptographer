import java.io.*;
import java.nio.file.Path;

public class Util {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private Util() {

    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readerString() {
        String string;
        try {
            string = br.readLine();
        } catch (IOException e) {
            writeMessage("Произошла ошибка при попытке ввода текста, попробуйте еще раз");
            string = readerString();
        }
        return string;
    }

    public static int readInt() {
        int number;
        try {
            number = Integer.parseInt(readerString());
        } catch (NumberFormatException e) {
            writeMessage("Произошла ошибка при попытке ввода числа, попробуйте еще раз");
            number = readInt();
        }
        return number;
    }

    public static Path builderFileName(String path, String suffix){
        Path fullPath = Path.of(path);
        String fileName = fullPath.getFileName().toString();
        if(fileName.contains(".")){
            int index = fileName.lastIndexOf(".");
            fileName = fileName.substring(0,index) + suffix + fileName.substring(index);

        }else {
            fileName = fileName + suffix;
        }

        return fullPath.getParent().resolve(fileName);
    }
}
