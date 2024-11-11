public class Kasir {
    private String namaProduk;
    private int hargaBarang;
    private int stokBarang;

    public String getNama() {
        return namaProduk;
    }

    public void setNama(String nama) {
        this.namaProduk = nama;
    }

    public int getHarga() {
        return hargaBarang;
    }

    public void setHarga(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public int getStok() {
        return stokBarang;
    }

    public void setStok(int stokBarang) {
        this.stokBarang = stokBarang;
    }
}
