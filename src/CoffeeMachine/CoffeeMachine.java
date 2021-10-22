package CoffeeMachine;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class CoffeeMachine {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Integer water_cost = 200;
        Integer milk_cost = 50;
        Integer beans_cost = 15;
        ArrayList<Integer> min_possible_cup = new ArrayList<>();

        System.out.println("Write how many ml of water the coffee machine has:");
        Integer water_amount = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        Integer milk_amount = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        Integer beans_amount = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        Integer cups_amount = scanner.nextInt();

        min_possible_cup.add(water_amount/water_cost);
        min_possible_cup.add(milk_amount/milk_cost);
        min_possible_cup.add(beans_amount/beans_cost);
        Integer min_cups = Collections.min(min_possible_cup);

        if(cups_amount.equals(min_cups)) System.out.println("Yes, I can make that amount of coffee");
        if(cups_amount < min_cups) System.out.println("Yes, I can make that amount of coffee (and even "
                        +(min_cups-cups_amount)+" more than that)");
        if(cups_amount > min_cups) System.out.println("No, I can make only "
                +min_cups+" cups of coffee");
    }
}
