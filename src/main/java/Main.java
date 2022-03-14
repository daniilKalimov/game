
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        try {


            boolean flag = false;
            Map<String, String> moves = null;
            for (int i = 0; i < args.length - 1; i++) {
                if (!args[i].equals(args[i + 1])) {
                    flag = true;
                } else {
                    flag = false;
                    System.out.println("Error input data\nshould not be identical elements, " +
                            "there should be for example: stone paper lizard ");
                }
            }
            if (args.length >= 3 && args.length % 2 != 0 && flag) {
                moves = new LinkedHashMap<>();
                for (Integer i = 0, j = 1; i < args.length; i++, j++) {
                    moves.put(j.toString(), args[i]);
                }
                moves.put("0", "exit");
                moves.put("?", "help");

            } else System.out.println("Error input data\nMust be 3 or more elements and " +
                    "odd amount, for example:stone paper lizard");
            String enter = " ";

            loop:
            while (!enter.equals("0")) {
                String step = Key.randomNumberStep(moves);
                Key.keyBytes(step);
                boolean ind = true;
                while (ind) {
                    System.out.println("Available moves:");
                    for (Map.Entry<String, String> i : moves.entrySet()) {
                        System.out.println(i.getKey() + " - " + i.getValue());
                    }
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter you move:");
                    enter = scanner.nextLine();
                    if (!moves.containsKey(enter)) continue;
                    if (enter.equals("0")) continue loop;
                    if (enter.equals("?")){ Table.show(moves); continue;}
                    System.out.println("Your move:" + moves.get(enter));
                    System.out.println("Computer move:" + step);
                    Rules.mehanicsGame(moves, step, moves.get(enter));
                    ind = false;

                    System.out.println(String.format("HMAC key: %032x\n\n",
                            new BigInteger(1, Key.randomKeyBytesFirst())));
                }


            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
