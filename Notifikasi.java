abstract class Notifikasi {
    protected String pesan;
    
    public Notifikasi(String pesan) {
        this.pesan = pesan;
    }
    
    public abstract void kirim();
}

class Email extends Notifikasi {
    public Email(String pesan) { super(pesan); }
    
    @Override
    public void kirim() {
        System.out.println("📧 Email: " + pesan);
    }
}

class SMS extends Notifikasi {
    public SMS(String pesan) { super(pesan); }
    
    @Override
    public void kirim() {
        System.out.println("📱 SMS: " + pesan);
    }
}