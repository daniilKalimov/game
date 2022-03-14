import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


public class Key {
    private static final byte KEY_SIZE_IN_BYTES = 16;


    public static String randomNumberStep(Map moves) {
        SecureRandom random = new SecureRandom();
        Integer number = random.nextInt(moves.size() - 2) + 1;

        return moves.get(number.toString()).toString();
    }

    public static void keyBytes(String s) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac sha256Hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(randomKeyBytesFirst(), "HmacSHA256");
        sha256Hmac.init(keySpec);
        byte[] macData = sha256Hmac.doFinal(s.getBytes());
        System.out.println(String.format("HMAC: %032x", new BigInteger(1, macData)));

    }

    public static byte[] randomKeyBytesFirst(){
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[KEY_SIZE_IN_BYTES];
        random.nextBytes(bytes);
        return bytes;
    }


}
