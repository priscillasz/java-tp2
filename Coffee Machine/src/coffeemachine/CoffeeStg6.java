package coffeemachine;

import java.util.Scanner;

public class CoffeeStg6 {
    // coffee ingredients + money + cups
    static int money = 550;
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;

    // to check if program can stop running
    static boolean exit = false;

    // buy something from the menu
    public static void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappucino, back - to main menu:");
        String option = scanner.next();

        switch (option) {
            case "1": // espresso
                if (doable(250,0,16)) {
                    water -= 250;
                    coffeeBeans -= 16;
                    cups -= 1;
                    money += 4;
                }
                break;
            case "2": // latte
                if (doable(350, 75,20)) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    cups -= 1;
                    money += 7;
                }
                break;
            case "3": // cappucino
                if (doable(200, 100, 12)) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    cups -= 1;
                    money += 6;
                }
                break;
            case "back": // voltar ao menu
                break;
        }

    }

    // fill material
    public static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();
    }

    public static void take() {
        System.out.println("I gave you $"+money);
        money -= money;
    }

    // remaining - output all the resources the coffee machine has
    public static void machineContent() {
        System.out.println("The coffee machine has:");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(coffeeBeans+" g of coffee beans");
        System.out.println(cups+" disposable cups");
        System.out.println("$"+money+" of money");
    }

    // exit - switch off the coffee machine
    public static void switchOff() {
        exit = true;
    }

    // check if there are enough resources to make coffee
    public static boolean doable(int waterNeeded, int milkNeeded, int beansNeeded) {
        if (water >= waterNeeded) {
            if (milk >= milkNeeded) {
                if (coffeeBeans >= beansNeeded) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    return true;
                } else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }
            } else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            option = scanner.nextLine();

            switch (option) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    machineContent();
                    break;
                case "exit":
                    switchOff();
                    break;
            }
        } while (!exit);
    }
}
