public class NonPlayableChar extends Character {
    private Character realIdentity;
    
    public NonPlayableChar(Character ch) {
        this.name = ch.name;
        this.realIdentity = ch;
    }
    
    @Override
    public void doWork() {
        realIdentity.doWork();
    }
    
    // Method untuk mendapatkan identitas asli
    public Character getRealIdentity() {
        return realIdentity;
    }
}