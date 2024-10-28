package restaurant;

public class MenuItem {
    public String name;
    public int quantity;
    public int price;
    public static int total1 = 0;
    private int cnt = 0;

    public MenuItem(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void orderItem(int requestedQuantity) {
        if (quantity >= requestedQuantity) {
            quantity -= requestedQuantity;
            cnt += requestedQuantity;
            int itemCost = requestedQuantity * price;
            total1 += itemCost;
            System.out.println("Requested Quantity : " + requestedQuantity);
            System.out.println("The bill is        : Rs " + itemCost);
        } else {
            System.out.println("Sorry, only " + quantity + " " + name + " left in stock");
        }
    }

    public int getCount() {
        return cnt;
    }

    public static void displayTotal(MenuItem[] items) {
        System.out.println("----------------------------------------");
        System.out.println("              Final Items");
        System.out.println("----------------------------------------");
        for (MenuItem item : items) {
            System.out.printf("%-15s : %d\n", item.name, item.getCount());
        }
        System.out.println("----------------------------------------");
        System.out.println("Total Bill Is: Rs " + total1);
        System.out.println("----------------------------------------");
    }

    public static void displayTotalOrdered(MenuItem[] items) {
        System.out.println("----------------------------------------");
        System.out.println("              Ordered Items");
        System.out.println("----------------------------------------");
        for (MenuItem item : items) {
            System.out.printf("%-15s : %d\n", item.name, item.getCount());
        }
        System.out.println("----------------------------------------");
    }
}
