public class Shopipedia {
    public static void main(String[] args) {
        // Miki dengan ShopiPay
        ShopiPay shopiCard = new ShopiPay();
        Customer miki = new Customer(shopiCard);
        miki.deposit(10000);
        miki.pay(2000);
        miki.pay(3000);
        miki.deposit(1000);
        miki.pay(7000);
        
        System.out.println("------------------");
        
        // Dono dengan Opo
        Opo opoCard = new Opo();
        Customer dono = new Customer(opoCard);
        dono.deposit(10000);
        dono.pay(2000);
        dono.pay(3000);
        dono.deposit(1000);
        dono.pay(7000);
        
        System.out.println("------------------");
        
        // Budi dengan Kris (Nomor 3)
        Kris krisCard = new Kris();
        Customer budi = new Customer(krisCard);
        budi.deposit(10000);
        budi.pay(2000);
        budi.pay(3000);
        budi.deposit(1000);
        budi.pay(7000);
        
        //tanpa class Kris
        /*
        Emoney krisCard = new Emoney() {
            {
                this.name = "Kris";
            }
            
            @Override
            public void topUp(double amount) {
                System.out.println("Top up: " + amount);
                this.balance += (amount + (0.05 * amount));
                this.balance();
            }
            
            @Override
            public void pay(double amount) {
                double amountToPay = amount - (0.03 * amount);
                if (this.balance > amountToPay) {
                    this.balance -= amountToPay;
                    System.out.printf("Pay " + amount);
                    System.out.println(" using " + this.name);
                } else {
                    System.out.println("Not enough balance.");
                }
                this.balance();
            }
        };
        
        Customer budi = new Customer(krisCard);
        budi.deposit(10000);
        budi.pay(2000);
        budi.pay(3000);
        budi.deposit(1000);
        budi.pay(7000);
        */
    }
}