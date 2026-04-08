public class Impostor implements IImpostor, ICrew, IKickable {
    private final String name;
    
    public Impostor(String name) {
        this.name = name;
    }
    
    @Override
    public void kill(ICrew crew) {
        System.out.println(crew.getName() + " has been killed!");
        crew.kill();
    }
    
    @Override
    public void doWork() {
        System.out.println("Impostor " + this.name + " is doing work.");
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public void kick() {
        System.out.println("Impostor " + this.name + " has been kicked out!");
    }
}