public class Crew implements ICrew, IKickable {
    private String name;
    private boolean isAlive = true; // ✅ Status awal hidup
    
    public Crew(String name) {
        this.name = name;
    }
    
    @Override
    public void doWork() {
        System.out.println("Crew " + this.name + " is doing work.");
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public void kill() {
        this.isAlive = false;
    }
    
    @Override
    public boolean isAlive() {
        return this.isAlive;
    }
    
    public void callMeeting() {
        if (this.isAlive) {
            System.out.print(this.name + " found a corpse");
            System.out.print(" and calls a meeting.");
            System.out.println(" Let's find the impostor!");
        } else {
            System.out.println(this.name + " is dead and cannot call a meeting!");
        }
    }
    
    @Override
    public void kick() {
        System.out.println("Crew " + this.name + " has been kicked out!");
    }
}