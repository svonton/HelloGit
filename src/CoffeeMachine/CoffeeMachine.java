package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Integer water_cost = 200;
        Integer milk_cost = 50;
        Integer beans_cost = 15;

        System.out.println("Write how many cups of coffee you will need:");
        Integer amount_of_cups = scanner.nextInt();

        System.out.println("For "+amount_of_cups+" cups of coffee you will need:\n"
                +amount_of_cups*water_cost+" ml of water\n"
                +amount_of_cups*milk_cost+" ml of milk\n"
                +amount_of_cups*beans_cost+" g of coffee beans");
    }
}
