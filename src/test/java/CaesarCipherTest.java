import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaesarCipherTest {
    private CaesarCipher caesar = new CaesarCipher();

//    private String notEncrypt = "abc";
//    private String encrypt = "def";
//    private int key = 3;
    @Test
    public void encrypt1() {
        assertEquals(caesar.encrypt("abc", 3),"def");
    }

    @Test
    public void encrypt2() {
        assertEquals(caesar.encrypt("abc", 29),"def");
    }

    @Test
    public void encrypt3() {
        assertEquals(caesar.encrypt("zoo", 3),"crr");
    }

    @Test
    public void encrypt4() {
        assertEquals(caesar.encrypt("Δ", 0),"");
    }

    @Test
    public void decrypt1() {
        assertEquals(caesar.decrypt("def", 3), "abc");
    }

    @Test
    public void decrypt2() {
        assertEquals(caesar.decrypt("def", 29),"abc");
    }

    @Test
    public void decrypt3() {
        assertEquals(caesar.decrypt("crr", 3),"zoo");
    }
}