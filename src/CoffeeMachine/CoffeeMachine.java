package CoffeeMachine;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

class Machine {
    Integer[] res = {400,540,120,9,550};
    ArrayList<Integer> machine_resources = new ArrayList<>(Arrays.asList(res));

    public int getWater() {
        return machine_resources.get(0);
    }

    public int getCups() {
        return machine_resources.get(3);
    }

    public int getBeans() {
        return machine_resources.get(2);
    }

    public int getMilk() {
        return machine_resources.get(1);
    }

    public int getMoney() {
        return machine_resources.get(4);
    }

    public void buy_process(int water, int milk, int beans, int money){
        if(getWater()-water>=0 && getMilk()-milk>=0 && getCups()>0 && getBeans()-beans>=0){
            this.machine_resources.set(0,getWater()-water);
            this.machine_resources.set(1,getMilk()-milk);
            this.machine_resources.set(3,getCups()-1);
            this.machine_resources.set(2,getBeans()-beans);
            this.machine_resources.set(4,getWater()+money);
            System.out.println("Coffee is ready");
        }
        else{
            System.out.println("Such ingredients are missing:");
            if (getWater()-water<0){
                System.out.println("Water");
            }
            if (getMilk()-milk<0){
                System.out.println("Beans");
            }
            if (getCups() == 0){
                System.out.println("Cups");
            }
            if(getBeans()-beans<0){
                System.out.println("Beans");
            }
        }
    }

    public void takeMoney(){
        System.out.println("I give you " + this.machine_resources.get(4));
        this.machine_resources.set(4,0);
    }

    public void print_status(){
        System.out.println("The coffee machine has:\n" +
                getWater()+" of water\n" +
                getMilk()+" of milk\n" +
                getBeans()+" of coffee beans\n" +
                getCups()+" of disposable cups\n" +
                getMoney()+" of money\n");
    }

    public void refill(){
        ArrayList<Integer> resources = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        this.machine_resources.set(0,getWater()+scan.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        this.machine_resources.set(1,getMilk()+scan.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.machine_resources.set(2,getBeans()+scan.nextInt());
        System.out.println("Write how many disposable coffee cups you want to add:");
        this.machine_resources.set(3,getCups()+scan.nextInt());
    }
}


public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine();

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String user_action = scanner.nextLine();
            if (Objects.equals(user_action, "buy")) {
                while (true){
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
                    String user_coffee = scanner.nextLine();
                    if (Objects.equals(user_coffee, "back")) {
                        break;
                    }
                    else if(Objects.equals(user_coffee, "1")){
                        machine.buy_process(250,0,16, 4);
                        break;
                    }
                    else if(Objects.equals(user_coffee, "2")){
                        machine.buy_process(350,75,20, 7);
                        break;
                    }
                    else if(Objects.equals(user_coffee, "3")){
                        machine.buy_process(200,100,12, 6);
                        break;
                    }
                }
            }
            else if (Objects.equals(user_action, "fill")) {
                    machine.refill();
                } else if (Objects.equals(user_action, "take")) {
                    machine.takeMoney();
                } else if (Objects.equals(user_action, "remaining")) {
                    machine.print_status();
                } else if (Objects.equals(user_action, "exit")) {
                    break;
                }
            }

        }
    }

