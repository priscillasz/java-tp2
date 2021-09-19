package coffeemachine;

import java.util.Scanner;

public class CoffeeStg3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!\n");

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int coffeeCups = scanner.nextInt();

        int availableCups = Math.min(water/200, Math.min(milk/50, coffeeBeans/15));

        if (coffeeCups > availableCups)
            System.out.println("No, I can make only "+availableCups+" cup(s) of coffee");
        else if (coffeeCups == availableCups)
            System.out.println("Yes, I can make that amount of coffee");
        else
            System.out.println("Yes, I can make that amount of coffee (and even "+(availableCups - coffeeCups)+ " more than that)");

    }
}
