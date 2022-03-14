import java.util.Map;

public class Rules {
    private static int numOne;
    private static int numTwo;

    public static void mehanicsGame(Map<String, String> move, String stepComputer, String stepUser) {

        for (Map.Entry<String, String> i : move.entrySet()) {
            if (i.getValue().equals(stepComputer))
                numOne = Integer.parseInt(i.getKey());
            if (i.getValue().equals(stepUser))
                numTwo = Integer.parseInt(i.getKey());
        }
        if (numOne > numTwo && numOne <= numTwo + (move.size() - 3) / 2) {
            System.out.println("Computer win!");
        } else if (numOne > numTwo) System.out.println("You win!");
        else if (numOne < numTwo && numOne >= numTwo + (move.size() - 3) / 2)
            System.out.println("You win!");
        else if (numOne < numTwo) System.out.println("Computer win!");
        else if (numOne == numTwo) System.out.println("Draw");
    }
}
