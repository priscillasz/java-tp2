package coffeemachine;

import java.util.Scanner;

public class CoffeeStg4 {
    static int money = 550;
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;

    public static void machineContent() {
        System.out.println("The coffee machine has:");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(coffeeBeans+" g of coffee beans");
        System.out.println(cups+" disposable cups");
        System.out.println("$"+money+" of money");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        machineContent();

        System.out.println("\nWrite action (buy, fill, take):");
        String action = scanner.next();

        if (action.equals("buy")) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappucino:");
            int option = scanner.nextInt();

            if (option == 1) { // espresso
                water -= 250;
                coffeeBeans -= 16;
                cups -= 1;
                money += 4;

            } else if (option == 2) { // latte
                water -= 350;
                milk -= 75;
                coffeeBeans -= 20;
                cups -= 1;
                money += 7;

            } else if (option == 3) { // cappucino
                water -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                cups -= 1;
                money += 6;
            }
            machineContent();

        } else if (action.equals("fill")) {
            System.out.println("Write how many ml of water you want to add:");
            water += scanner.nextInt();
            System.out.println("Write how many ml of milk you want to add:");
            milk += scanner.nextInt();
            System.out.println("Write how many grams of coffee beans you want to add:");
            coffeeBeans += scanner.nextInt();
            System.out.println("Write how many disposable cups of coffee you want to add:");
            cups += scanner.nextInt();

            machineContent();
        } else if (action.equals("take")) {
            money -= money;
             machineContent();
        }
    }
}
