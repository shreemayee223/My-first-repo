import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Electricity Bill Management System =====");
            System.out.println("1. Generate New Bill");
            System.out.println("2. View Saved Bills");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Consumer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Consumer ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Units Consumed: ");
                    double units = sc.nextDouble();

                    double billAmount = BillCalculator.calculateBill(units);

                    Consumer consumer = new Consumer(name, id, units, billAmount);

                    
                    consumer.displayBill();

                    
                    DBHandler.saveToDB(consumer);
                    break;

                case 2:
                    System.out.println("\n--- Saved Bills from Database ---");
                    List<Consumer> consumers = DBHandler.readFromDB();
                    for (Consumer c : consumers) {
                        c.displayBill();
                    }
                    break;

                case 3:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("⚠ Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}

