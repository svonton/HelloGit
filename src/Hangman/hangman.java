package Hangman;
import java.util.Objects;
import java.util.Scanner;

public class hangman {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");
        String answer = "java";
        System.out.print("Guess the word: ");
        String user_input = scanner.nextLine();
        if (Objects.equals(user_input, answer)){
            System.out.println("You survived!");
        }
        else{
            System.out.println("You lost!");
        }
    }
}
