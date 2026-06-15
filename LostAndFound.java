import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String itemName;
    String description;
    String location;
    String status;

    Item(String itemName, String description, String location, String status) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    void display() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Description : " + description);
        System.out.println("Location : " + location);
        System.out.println("Status : " + status);
        System.out.println("----------------------------");
    }
}

public class LostAndFound {

    static ArrayList<Item> items = new ArrayList<>();

    public static void addLostItem(Scanner sc) {
        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Description: ");
        String desc = sc.nextLine();

        System.out.print("Enter Lost Location: ");
        String loc = sc.nextLine();

        items.add(new Item(name, desc, loc, "Lost"));

        System.out.println("Lost Item Added Successfully!");
    }

    public static void addFoundItem(Scanner sc) {
        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Description: ");
        String desc = sc.nextLine();

        System.out.print("Enter Found Location: ");
        String loc = sc.nextLine();

        items.add(new Item(name, desc, loc, "Found"));

        System.out.println("Found Item Added Successfully!");
    }

    public static void viewLostItems() {
        boolean found = false;

        System.out.println("\n--- Lost Items ---");
        for (Item item : items) {
            if (item.status.equalsIgnoreCase("Lost")) {
                item.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Lost Items Available.");
        }
    }

    public static void viewFoundItems() {
        boolean found = false;

        System.out.println("\n--- Found Items ---");
        for (Item item : items) {
            if (item.status.equalsIgnoreCase("Found")) {
                item.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Found Items Available.");
        }
    }

    public static void searchItem(Scanner sc) {
        System.out.print("Enter Item Name to Search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (Item item : items) {
            if (item.itemName.equalsIgnoreCase(searchName)) {
                item.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Item Not Found.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LOST AND FOUND MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Lost Item");
            System.out.println("2. Add Found Item");
            System.out.println("3. View Lost Items");
            System.out.println("4. View Found Items");
            System.out.println("5. Search Item");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addLostItem(sc);
                    break;

                case 2:
                    addFoundItem(sc);
                    break;

                case 3:
                    viewLostItems();
                    break;

                case 4:
                    viewFoundItems();
                    break;

                case 5:
                    searchItem(sc);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
