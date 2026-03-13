public class Mobil{
    private String nopol;
    private String warna;
    private String merk;
    private int kecepatan;
    private double jarakTempuh;
    
    public void setNopol(String n){
        nopol = n;
    }
    
    public void setWarna(String s){
        warna = s;
    }
    
    public void setMerk(String m){
        merk = m;
    }
    
    public void setKecepatan(int k){
        kecepatan = k;
    }
    
    public void setJarakTempuh(double j){
        jarakTempuh = j;
    }
    
    public double hitungJarak(double waktu){
        return kecepatan * waktu;
    }
    
    public double kecepatanMPerDetik(){
        return (double) kecepatan / 3.6;
    }
    
    public void display(){
        System.out.println("Mobil bermerk " + merk);
        System.out.println("bernomor polisi " + nopol);
        System.out.println("serta memililki warna " + warna);
        System.out.println("bergerak dengan kecepatan " + kecepatan + " kpj");
        System.out.println("dengan jarak tempuh " + jarakTempuh + " km");
    }
}