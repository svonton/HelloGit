package Hangman;
import java.util.*;

public class hangman {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("HANGMAN");
        String[] answers = {"java","python", "javascript", "kotlin"};
        String answer = answers[rand.nextInt(answers.length)];

        ArrayList<String> word_viewer = new ArrayList<String>(Arrays.asList(answer.split("")));
        for (int i=0; i < word_viewer.size(); i++){
            word_viewer.set(i,"-");
        }

        Set<String> right_letters = new HashSet<String>(Arrays.asList(answer.split("")));

        int health_points = 8;
        while (health_points != 0){
            System.out.println(String.join("",word_viewer));
            System.out.print("Input a letter: ");
            String user_input = scanner.nextLine();
            if (right_letters.contains(user_input)){
                if(!word_viewer.contains(user_input)){
                    ArrayList<Integer> indexes = char_switcher(user_input,answer);
                    for(int i : indexes){
                        word_viewer.set(i,user_input);
                    }
                }
                else{
                    System.out.println("No improvements");
                    health_points -= 1;
                }
            }
            else{
                System.out.println("That letter doesn't appear in the word");
                health_points -= 1;
            }

            if(!word_viewer.contains("-")){
                System.out.println(String.join("",word_viewer));
                System.out.println("You guessed the word!\n" +
                        "You survived!\n");
                break;
            }
        }
        if(health_points == 0){
            System.out.println("You lost!");
        }
    }
    public static ArrayList<Integer> char_switcher(String user_input, String right_word){
        ArrayList<String> word_chars = new ArrayList<String>(Arrays.asList(right_word.split("")));
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int i=0; i < word_chars.size();i++){
            if(Objects.equals(word_chars.get(i), user_input)){
                indexes.add(i);
            }
        }
        return indexes;
    }
}
