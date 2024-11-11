import java.util.Scanner;

public class MVCKasir {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Kasir kasir = new Kasir();
        kasir.setNama("GeForce GTX 1060Ti");
        kasir.setHarga(3000);
        kasir.setStok(10);

        KasirView view = new KasirView();
        KasirController controller = new KasirController(kasir, view);
        controller.updateView();

        System.out.println("Transaksi Pembelian");
        System.out.print("Jumlah Barang: ");
        int qty = in.nextInt();
        controller.setStok(controller.getStok() - qty);

        System.out.println("Jumlah Bayar: " + qty * controller.getHarga());

        System.out.println("\nSetelah Transaksi, info barang sebagai berikut: ");
        controller.updateView();

        in.close();
    }
}
