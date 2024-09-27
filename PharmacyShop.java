public class PharmacyShop {
    private Person owner;
    private Address address;
    private Medicine[] medicines;
    private int medicineCount;
    private double totalRevenue;

    public PharmacyShop(Person owner, Address address) {
        this.owner = owner;
        this.address = address;
        this.medicines = new Medicine[100];
        this.medicineCount = 0;
        this.totalRevenue = 0;
    }

    public void addMedicine(Medicine medicine) {
        if (medicineCount < 100) {
            medicines[medicineCount] = medicine;
            medicineCount++;
            System.out.println("Medicine added successfully!");
        } else {
            System.out.println("Medicine cannot be added. Inventory is full.");
        }
    }

    public void updateMedicine(String medicineId, Medicine updatedMedicine) {
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i].getMedicineId().equals(medicineId)) {
                medicines[i] = updatedMedicine;
                System.out.println("Medicine updated successfully!");
                return;
            }
        }
        System.out.println("Medicine not found.");
    }

    public void removeMedicine(String medicineId) {
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i].getMedicineId().equals(medicineId)) {
                for (int j = i; j < medicineCount - 1; j++) {
                    medicines[j] = medicines[j + 1];
                }
                medicineCount--;
                System.out.println("Medicine removed successfully!");
                return;
            }
        }
        System.out.println("Medicine not found.");
    }

    public void sellMedicine(String medicineId, int quantity) {
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i].getMedicineId().equals(medicineId)) {
                if (medicines[i].getQuantity() >= quantity) {
                    medicines[i].setQuantity(medicines[i].getQuantity() - quantity);
                    totalRevenue += medicines[i].getPrice() * quantity;
                    System.out.println("Medicine sold successfully!");
                } else {
                    System.out.println("Not enough quantity available.");
                }
                return;
            }
        }
        System.out.println("Medicine not found.");
    }

    public void displayMedicines() {
        for (int i = 0; i < medicineCount; i++) {
            medicines[i].displayInformation();
            System.out.println();
        }
    }

    public void searchMedicine(String medicineId) {
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i].getMedicineId().equals(medicineId)) {
                medicines[i].displayInformation();
                return;
            }
        }
        System.out.println("Medicine not found.");
    }

    public void printTotalRevenue() {
        System.out.println("Total Revenue: " + totalRevenue);
    }

    public void identifyExpiredMedicines() {
        Date currentDate = new Date(27, 9, 2024);
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i].getExpiryDate().getYear() < currentDate.getYear() ||
                    (medicines[i].getExpiryDate().getYear() == currentDate.getYear() &&
                            medicines[i].getExpiryDate().getMonth() < currentDate.getMonth()) ||
                    (medicines[i].getExpiryDate().getYear() == currentDate.getYear() &&
                            medicines[i].getExpiryDate().getMonth() == currentDate.getMonth() &&
                            medicines[i].getExpiryDate().getDay() < currentDate.getDay())) {
                medicines[i].displayInformation();
            }
        }
    }
}