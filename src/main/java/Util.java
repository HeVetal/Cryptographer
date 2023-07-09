import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    private Util(){

    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String readerString() {
        String str;
        try  {
            str = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
}
