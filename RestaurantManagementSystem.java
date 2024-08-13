import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    private int id;
    private String name;
    private double price;

    public MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Order(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class RestaurantManagementSystem {
    private List<MenuItem> menuItems;
    private List<Order> orders;

    public RestaurantManagementSystem() {
        this.menuItems = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addMenuItem(int id, String name, double price) {
        menuItems.add(new MenuItem(id, name, price));
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (MenuItem item : menuItems) {
            System.out.println("ID: " + item.getId() + ", Name: " + item.getName() + ", Price: " + item.getPrice());
        }
    }

    public void takeOrder(int id, int quantity) {
        for (MenuItem item : menuItems) {
            if (item.getId() == id) {
                orders.add(new Order(id, item.getName(), item.getPrice(), quantity));
                System.out.println("Order placed successfully!");
                return;
            }
        }
        System.out.println("Menu item not found!");
    }

    public void displayOrders() {
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println("ID: " + order.getId() + ", Name: " + order.getName() + ", Price: " + order.getPrice() + ", Quantity: " + order.getQuantity());
        }
    }

    public static void main(String[] args) {
        RestaurantManagementSystem rms = new RestaurantManagementSystem();
        Scanner scanner = new Scanner(System.in);

        rms.addMenuItem(1, "Burger\t", 80);
        rms.addMenuItem(2, "Pizza\t", 150);
        rms.addMenuItem(3, "Salad\t", 30);
	rms.addMenuItem(4, "Sandwich\t", 60);


        while (true) {
	    System.out.println("========================================WELCOME TO FAST CHAIN RESTURENT===========================================");
            System.out.println("1. Display Menu\n");
            System.out.println("2. Take Order\n");
            System.out.println("3. Display Orders\n");
            System.out.println("4. Exit\n\n");
	    System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.print("Please choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    rms.displayMenu();
                    break;
                case 2:
                    System.out.print("Please enter menu item ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    rms.takeOrder(id, quantity);
                    break;
                case 3:
                    rms.displayOrders();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry this option does not exist :(");
            }
        }
    }
}
