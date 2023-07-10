import java.io.*;

public class Util {
    private Util() {

    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String readerString() {
        String str;
        try {
            str = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

    static {

        File file = new File("C:/path/to/myfile.txt");

        String nameFile = file.getName();
        int lastIndex = nameFile.lastIndexOf('.');
        if(lastIndex != -1){
            nameFile = nameFile.substring(0, lastIndex);
            System.out.println(nameFile);
        }

        if(!nameFile.contains("Encrypted")){
            nameFile = nameFile + "Encrypted.txt";
        }
    }
}
