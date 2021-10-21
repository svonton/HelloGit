package Hangman;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("HANGMAN");
        String[] answers = {"java","python", "javascript", "kotlin"};
        String answer = answers[rand.nextInt(answers.length)];
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
