public class AmongUsGame {
    public static void main(String[] args) {
        // Create references of Character
        Character brian, cindy, david, jacky;
        brian = new Crew("Brian");
        cindy = new Crew("Cindy");
        david = new Crew("David");
        jacky = new Crew("Jacky");
        
        brian.doWork();
        cindy.doWork();
        david.doWork();
        jacky.doWork();
        
        // Jadikan Jacky sebagai Impostor
        jacky = (Character) new Impostor(jacky);
        jacky.kill(cindy);
        
        // Tambahkan: Pakai "topeng" NonPlayableChar
        jacky = (Character) new NonPlayableChar(jacky);
        
        if (david instanceof Crew crew)
            crew.callMeeting();
        
        AmongUsGame.check(brian);
        AmongUsGame.check(david);
        AmongUsGame.check(jacky);
        
        // Optional: Cek identitas asli
        System.out.println("\n--- Checking real identity ---");
        if (jacky instanceof NonPlayableChar npc) {
            Character real = npc.getRealIdentity();
            if (real instanceof Impostor) {
                System.out.println(jacky.name + " is actually an Impostor!");
            }
        }
    }
    
    public static void check(Character ch) {
        if (AmongUsGame.isImpostor(ch))
            System.out.println(ch.name + " is the impostor!");
        else
            System.out.println(ch.name + " is not the impostor.");
    }
    
    public static boolean isImpostor(Character ch) {
        return (ch instanceof Impostor);
    }
}