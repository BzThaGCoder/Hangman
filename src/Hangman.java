import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String wordPlayer1 = "";
        String wordGuess;
        int numOfGuesses = 8;


        System.out.println("Player One, enter a word:");
        //wordPlayer1 = sc.nextLine();

        wordPlayer1 = sc.nextLine();

        String underscore = "";

        for (int k = 0; k < wordPlayer1.length();k++)
        {
            //System.out.print(underscore);
            underscore = underscore + "_";
        }

        System.out.println(underscore + "");

        System.out.print("");

        String underscoreNew = "";

        while (numOfGuesses != 0) {

            System.out.println("Player Two, you have " + numOfGuesses + " guesses left. Enter a guess:");
            wordGuess = sc.nextLine();

            if (underscoreNew.contains(wordGuess))
            {
                System.out.println("You have already guessed '" + wordGuess + "'.");
                System.out.println(underscoreNew);
                continue;
            }

            underscoreNew = "";                           //Reassign underscoreNew to an empty string

            for (int i = 0; i < wordPlayer1.length(); i++)
            {
                if (wordPlayer1.charAt(i) == wordGuess.charAt(0))
                {
                    underscoreNew = underscoreNew + wordGuess.charAt(0);
                    //System.out.println(underscoreNew);
                }
                else if (underscore.charAt(i) != '_')
                {
                    underscoreNew = underscoreNew + wordPlayer1.charAt(i);
                    //System.out.println(underscoreNew);
                }
                else {
                    underscoreNew = underscoreNew + "_";
                }
            }

            if (underscore.equals(underscoreNew)) {
                --numOfGuesses;
                if (numOfGuesses == 0)
                {
                    System.out.println("Game over. Player One wins! The word was: " + wordPlayer1);
                    //System.exit(0);
                    break;
                }
            } else {
                underscore = underscoreNew;
            }

            System.out.println(underscoreNew);//Underscore new that fills with values

            if (underscore.equals(wordPlayer1)) {
                System.out.println("Game over. Player Two wins!");
                //System.exit(0);
                break;
            }
        }
    }
}

