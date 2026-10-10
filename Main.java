import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        // Mengisi data awal nasabah
        bank.addCustomer("Muhammad", "Bintang");
        bank.addCustomer("Arifin", "Syah");

        // Menambahkan rekening ke nasabah pertama
        bank.getCustomer(0).setAccount(new Account(500000.0));
        bank.getCustomer(1).setAccount(new Account(1000000.0));

        System.out.println("==========================================");
        System.out.println("      SISTEM MANAJEMEN BANK & ATM         ");
        System.out.println("==========================================");

        Customer currentCustomer = bank.getCustomer(0);
        Account currentAccount = currentCustomer.getAccount();

        System.out.println("Selamat Datang, " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + "!");

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ATM ---");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Tunai (Deposit)");
            System.out.println("3. Tarik Tunai (Withdraw)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("Saldo Anda saat ini: Rp " + currentAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Masukkan jumlah setoran: Rp ");
                    double jumlahSetor = input.nextDouble();
                    if (currentAccount.deposit(jumlahSetor)) {
                        System.out.println("Setoran berhasil! Saldo baru: Rp " + currentAccount.getBalance());
                    } else {
                        System.out.println("Gagal! Jumlah setoran harus lebih besar dari 0.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan jumlah penarikan: Rp ");
                    double jumlahTarik = input.nextDouble();
                    if (currentAccount.withdraw(jumlahTarik)) {
                        System.out.println("Penarikan berhasil! Saldo tersisa: Rp " + currentAccount.getBalance());
                    } else {
                        System.out.println("Gagal! Saldo Anda tidak mencukupi.");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan bank kami.");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        input.close();
    }
}