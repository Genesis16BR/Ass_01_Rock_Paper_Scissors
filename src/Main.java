import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String playAgain = "";
        String moveA = "";
        String moveB = "";
        String result = "";

        do
        {
            System.out.print("Player A, enter your move (R,P,S): ");
            moveA = getPlayerMove(in);

            System.out.print("Player B, enter your move (R,P,S): ");
            moveB = getPlayerMove(in);

            result = determineWinner(moveA, moveB);
            System.out.println(result);

            System.out.print("Do you want to play again? (Y,N)");
            playAgain = in.next();
        } while (playAgain.equalsIgnoreCase("Y"));
    }

    public static String getPlayerMove(Scanner scanner) {
        String move = "";
        do {
            move = scanner.next().toUpperCase();
            if (!move.equalsIgnoreCase("R") && !move.equalsIgnoreCase("P") && !move.equalsIgnoreCase("S")) {
                System.out.print("Invalid move. Please enter R, P, or S: ");
            }
        } while (!move.equalsIgnoreCase("R") && !move.equalsIgnoreCase("P") && !move.equalsIgnoreCase("S"));
        return move;
    }

    public static String determineWinner(String moveA, String moveB) {
        if (moveA.equalsIgnoreCase(moveB)) {
            return "It's a Tie! Both players chose " + moveA;
        } else if ((moveA.equalsIgnoreCase("R") && moveB.equalsIgnoreCase("S")) ||
                (moveA.equalsIgnoreCase("P") && moveB.equalsIgnoreCase("R")) ||
                (moveA.equalsIgnoreCase("S") && moveB.equalsIgnoreCase("P"))) {
            return "Player A wins! " + getResultPhrase(moveA.toUpperCase(), moveB.toUpperCase());
        } else {
            return "Player B wins! " + getResultPhrase(moveB.toUpperCase(), moveA.toUpperCase());
        }
    }

    public static String getResultPhrase(String winningMove, String losingMove) {
        if (winningMove.equals("R")) {
            return "Rock breaks Scissors";
        } else if (winningMove.equals("P")) {
            return "Paper covers Rock";
        } else {
            return "Scissors cuts Paper";
        }
    }
}