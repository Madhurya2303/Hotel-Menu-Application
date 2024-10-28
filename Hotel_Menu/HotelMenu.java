import restaurant.MenuItem;
import java.util.Scanner;
import java.io.*;

public class HotelMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt quantities for each item
        System.out.print("The Quantity of pizza we have        : ");
        int q_pizza = scanner.nextInt();
        System.out.print("The Quantity of burger we have       : ");
        int q_burger = scanner.nextInt();
        System.out.print("The Quantity of noodles we have      : ");
        int q_noodles = scanner.nextInt();
        System.out.print("The Quantity of chicken rolls we have: ");
        int q_chicken = scanner.nextInt();
        System.out.print("The Quantity of fries we have        : ");
        int q_fries = scanner.nextInt();

        MenuItem[] menuItems = {
                new MenuItem("Pizza", q_pizza, 120),
                new MenuItem("Burger", q_burger, 100),
                new MenuItem("Noodles", q_noodles, 80),
                new MenuItem("Chicken Rolls", q_chicken, 150),
                new MenuItem("Fries", q_fries, 100)
        };

        System.out.println("----------------------------------------");
        System.out.println("            Menu we offer");
        System.out.println("----------------------------------------");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ")     " + menuItems[i].name);
        }
        System.out.println((menuItems.length + 1) + ")     Total you booked");
        System.out.println((menuItems.length + 2) + ")     Exit");
        System.out.println("----------------------------------------");

        // Loop for ordering process
        while (true) {
            System.out.print("Enter your choice below 1-" + (menuItems.length + 2) + "    : ");
            int choice = scanner.nextInt();

            if (choice == menuItems.length + 1) {
                MenuItem.displayTotalOrdered(menuItems);
            } else if (choice == menuItems.length + 2) {
                MenuItem.displayTotal(menuItems);
                System.out.println("THANK YOU FOR HAVING OUR SERVICES. WAITING FOR YOUR NEXT VISIT :)");

                // Writing order details to file
                try (Writer fWriter = new FileWriter("fileexp.txt", true)) {
                    fWriter.write("\n----------------------------------------");
                    fWriter.write("\n              Final Items");
                    fWriter.write("\n----------------------------------------\n");
                    for (MenuItem item : menuItems) {
                        fWriter.write(item.name + "                  \t\t: " + item.getCount() + "\n");
                    }
                    fWriter.write("\n----------------------------------------");
                    fWriter.write("\nTotal Bill Is: Rs " + MenuItem.total1);
                    fWriter.write("\n----------------------------------------\n");
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }

                System.exit(0);
            } else if (choice >= 1 && choice <= menuItems.length) {
                System.out.print("Enter quantity of " + menuItems[choice - 1].name + " you want: ");
                int quantity = scanner.nextInt();
                menuItems[choice - 1].orderItem(quantity);
            } else {
                System.out.println("Enter a valid choice from the menu.");
            }
        }
    }
}
