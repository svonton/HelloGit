package Hangman;
import java.util.*;

public class hangman {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("HANGMAN");
        String[] answers = {"java","python", "javascript", "kotlin"};
        String answer = answers[rand.nextInt(answers.length)];

        ArrayList<String> hint_char = new ArrayList<String>(Arrays.asList(answer.split("")));
        for (int i=2; i < hint_char.size();i++){
            hint_char.set(i,"-");
        }
        String hint = String.join("", hint_char);
        System.out.print("Guess the word "+hint+": ");


        String user_input = scanner.nextLine();
        if (Objects.equals(user_input, answer)){
            System.out.println("You survived!");
        }
        else{
            System.out.println("You lost!");
        }
    }
}
