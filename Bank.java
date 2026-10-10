public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    public Bank() {
        // Menginisialisasi array dengan kapasitas maksimal 10 nasabah
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    public void addCustomer(String f, String l) {
        if (numberOfCustomers < customers.length) {
            customers[numberOfCustomers++] = new Customer(f, l);
        } else {
            System.out.println("Kapasitas bank penuh!");
        }
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < numberOfCustomers) {
            return customers[index];
        }
        return null;
    }
}