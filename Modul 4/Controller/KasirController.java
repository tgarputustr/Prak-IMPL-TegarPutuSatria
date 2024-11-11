public class KasirController {
    private Kasir Model;
    private KasirView View;
    public KasirController(Kasir Model, KasirView View){
        this.Model = Model;
        this.View = View;
    }
    public String getNama() {
        return Model.getNama();
    }
    public void setNama(String nama) {
        Model.setNama(nama);
    }
    public int getHarga() {
        return Model.getHarga();
    }
    public void setHarga(int hargaBarang) {
        Model.setHarga(hargaBarang);
    }
    public int getStok() {
        return Model.getStok();
    }
    public void setStok(int stokBarang) {
        Model.setStok(stokBarang);
    }
    public void updateView() {
        View.printKasirInfo(getNama(), getHarga(), getStok());
    }
}
