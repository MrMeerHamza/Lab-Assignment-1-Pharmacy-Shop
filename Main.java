import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Person owner = new Person("Ahmed Khan", "03123456789");
        Address address = new Address("Street 1", "Karachi", "12345");
        PharmacyShop pharmacyShop = new PharmacyShop(owner, address);

        while (true) {
	    System.out.println();
            System.out.println("1. Add Medicine");
            System.out.println("2. Update Medicine");
            System.out.println("3. Remove Medicine");
            System.out.println("4. Sell Medicine");
            System.out.println("5. Display Medicines");
            System.out.println("6. Search Medicine");
            System.out.println("7. Print Total Revenue");
            System.out.println("8. Identify Expired Medicines");
            System.out.println("9. Exit");
	    System.out.println();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
	            System.out.println();
                    System.out.print("Enter medicine ID: ");
                    String medicineId = scanner.nextLine();
                    System.out.print("Enter medicine name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter medicine price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter medicine quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter medicine manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Enter medicine batch number: ");
                    String batchNumber = scanner.nextLine();
                    System.out.print("Enter medicine expiry date (day): ");
                    int expiryDay = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter medicine expiry date (month): ");
                    int expiryMonth = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter medicine expiry date (year): ");
                    int expiryYear = scanner.nextInt();
                    scanner.nextLine();
	            System.out.println();

                    Date expiryDate = new Date(expiryDay, expiryMonth, expiryYear);
                    Medicine medicine = new Medicine(medicineId, name, price, quantity, manufacturer, batchNumber, expiryDate);
                    pharmacyShop.addMedicine(medicine);
	            System.out.println();
                    break;

                case 2:
	            System.out.println();
                    System.out.print("Enter medicine ID: ");
                    medicineId = scanner.nextLine();
                    System.out.print("Enter new medicine name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new medicine price: ");
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter new medicine quantity: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new medicine manufacturer: ");
                    manufacturer = scanner.nextLine();
                    System.out.print("Enter new medicine batch number: ");
                    batchNumber = scanner.nextLine();
                    System.out.print("Enter new medicine expiry date (day): ");
                    expiryDay = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new medicine expiry date (month): ");
                    expiryMonth = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new medicine expiry date (year): ");
                    expiryYear = scanner.nextInt();
                    scanner.nextLine();
	            System.out.println();

                    expiryDate = new Date(expiryDay, expiryMonth, expiryYear);
                    medicine = new Medicine(medicineId, name, price, quantity, manufacturer, batchNumber, expiryDate);
                    pharmacyShop.updateMedicine(medicineId, medicine);
	            System.out.println();
                    break;

                case 3:
	            System.out.println();
                    System.out.print("Enter medicine ID: ");
                    medicineId = scanner.nextLine();
                    pharmacyShop.removeMedicine(medicineId);
	            System.out.println();
                    break;

                case 4:
	            System.out.println();
                    System.out.print("Enter medicine ID: ");
                    medicineId = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    pharmacyShop.sellMedicine(medicineId, quantity);
	            System.out.println();
                    break;

                case 5:
	            System.out.println();
                    pharmacyShop.displayMedicines();
	            System.out.println();
                    break;

                case 6:
	            System.out.println();
                    System.out.print("Enter medicine ID: ");
                    medicineId = scanner.nextLine();
                    pharmacyShop.searchMedicine(medicineId);
	            System.out.println();
                    break;

                case 7:
	            System.out.println();
                    pharmacyShop.printTotalRevenue();
	            System.out.println();
                    break;

                case 8:
	            System.out.println();
                    pharmacyShop.identifyExpiredMedicines();
	            System.out.println();
                    break;

                case 9:
	            System.out.println();
                    System.out.println("Exiting...");
	            System.out.println();
                    return;

                default:
	            System.out.println();
                    System.out.println("Invalid choice. Please try again.");
	            System.out.println();
            }
        }
    }
}