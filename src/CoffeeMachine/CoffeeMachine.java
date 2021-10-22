package CoffeeMachine;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Objects;

public class CoffeeMachine {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Integer[] res = {400,540,120,9,550};
        ArrayList<Integer> machine_resources = new ArrayList<>(Arrays.asList(res));

        print_status(machine_resources);

        System.out.println("Write action (buy, fill, take):");
        String user_action = scanner.nextLine();
        if(Objects.equals(user_action, "buy")){
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            ArrayList<Integer> buy_res = buy_process(scanner.nextInt());
            for(int i=0; i < buy_res.size();i++){
                machine_resources.set(i,machine_resources.get(i)+buy_res.get(i));
            }
        }
        if(Objects.equals(user_action,"fill")){
            ArrayList<Integer> res_to_add = refill();
            for(int i=0; i < res_to_add.size();i++){
                machine_resources.set(i,machine_resources.get(i)+res_to_add.get(i));
            }
        }
        if (Objects.equals(user_action,"take")){
            System.out.println("I gave you "+machine_resources.get(4));
            machine_resources.set(4,0);
        }
        System.out.println();
        print_status(machine_resources);
        System.out.println();
    }
    public static ArrayList<Integer> buy_process(Integer user_order){
        Integer[] resources_cost = {0,0,0,0,0};
        if(Objects.equals(user_order,1)){
            resources_cost = new Integer[]{-250,-0,-16,-1,4};
        }
        if(Objects.equals(user_order,2)){
            resources_cost = new Integer[]{-350,-75,-20,-1,7};
        }
        if(Objects.equals(user_order,3)){
            resources_cost = new Integer[]{-200, -100, -12,-1, 6};
        }
        return new ArrayList<>(Arrays.asList(resources_cost));
    }

    public static void print_status(ArrayList<Integer> res){
        System.out.println("The coffee machine has:\n" +
                res.get(0)+" of water\n" +
                res.get(1)+" of milk\n" +
                res.get(2)+" of coffee beans\n" +
                res.get(3)+" of disposable cups\n" +
                res.get(4)+" of money\n");
    }

    public static ArrayList<Integer> refill(){
        ArrayList<Integer> resources = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        resources.add(scan.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        resources.add(scan.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        resources.add(scan.nextInt());
        System.out.println("Write how many disposable coffee cups you want to add:");
        resources.add(scan.nextInt());
        return resources;
    }
}
