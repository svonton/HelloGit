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
        while (true){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String user_action = scanner.nextLine();
            if(Objects.equals(user_action, "buy")){
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
                String user_coffe = scanner.nextLine();
                if(Objects.equals(user_coffe,"back")){
                    continue;
                }
                else if(Objects.equals(user_coffe,"1") || Objects.equals(user_coffe,"2")
                        || Objects.equals(user_coffe,"3")){
                    ArrayList<Integer> buy_res = buy_process(Integer.parseInt(user_coffe));
                    if (machine_resources.get(0)+buy_res.get(0)>0 && machine_resources.get(1)+buy_res.get(1)>0 &&
                            machine_resources.get(2)+buy_res.get(2)>0 && machine_resources.get(3)+buy_res.get(3)>0){

                        for(int i=0; i < buy_res.size();i++){
                            machine_resources.set(i,machine_resources.get(i)+buy_res.get(i));
                        }
                        System.out.println("I have enough resources, making you a coffee!");
                    }
                    else{
                        System.out.println("Such ingredients are missing:");
                        if (machine_resources.get(0)+buy_res.get(0)>0){
                            System.out.println("Water");
                        }
                        if (machine_resources.get(1)+buy_res.get(1)>0){
                            System.out.println("Milk");
                        }
                        if (machine_resources.get(2)+buy_res.get(2)>0){
                            System.out.println("Beans");
                        }
                        if(machine_resources.get(3)+buy_res.get(3)>0){
                            System.out.println("Cups");
                        }
                    }
                    }
                }

            else if(Objects.equals(user_action,"fill")){
                ArrayList<Integer> res_to_add = refill();
                for(int i=0; i < res_to_add.size();i++){
                    machine_resources.set(i,machine_resources.get(i)+res_to_add.get(i));
                }
            }
            else if (Objects.equals(user_action,"take")){
                System.out.println("I gave you "+machine_resources.get(4));
                machine_resources.set(4,0);
            }
            else if (Objects.equals(user_action,"remaining")){
                System.out.println();
                print_status(machine_resources);
                System.out.println();
            }
            else if (Objects.equals(user_action,"exit")){
                break;
            }
        }

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
