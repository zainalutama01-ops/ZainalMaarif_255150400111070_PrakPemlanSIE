public class TiketBus extends Tiket {
    @Override
    public void pesan() {
        this.tujuan = "Bandung";
    }
    
    @Override
    public void pesan(String n, String t) {
        if (t.equals("Makassar")) {
            this.tujuan = "Makassar";
            System.out.println("Maaf " + n + ", tiket tidak dapat dipesan.");
        } else {
            this.namaPenumpang = n;
            this.tujuan = t;
            this.jarakTempuh = 90;
            this.hargaTiket = 55000;
        }
    }
    
    public void pesan(String n) { 
        this.namaPenumpang = n; 
    } 
    
    @Override
    public void tampil() {
        if (!this.tujuan.equals("Makassar")) {
            super.tampil();
        } else {
            System.out.println("Tiket tujuan Makassar tidak tersedia.");
            System.out.println("--------------------");
        }
    }
}