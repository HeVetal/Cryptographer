public class CaesarCipher {

    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt(String message, int key){
        String answer = "";
        for (int i = 0; i < message.length(); i++) {
           char charAt = message.charAt(i);
           int index = alphabet.indexOf(charAt);
           int newIndex = index + key;
           char newChar = alphabet.charAt(newIndex);
           answer += newChar;

        }
        return answer;
    }

    public String decrypt(String message, int key){
        return encrypt(message, key * (-1));=[]
    }
}
