public class Belt extends FieldElement implements Steppable {
    static int UNIQUE_ID = 0;

    private int uid = ++UNIQUE_ID;


    int getUniqueId() {
        return uid;
    }

    public int getLength() {
        return length;
    }

    private int length;
    private CollisionDetector collisionDetector;

    Belt(int length) {
        collisionDetector = new CollisionDetector();
        Timer.getInstance().addSteppable(this);
        this.length = length;
    }

    @Override
    void handlePackage(Pack p) {
        System.out.println("Belt: " + this.getUniqueId() + " Handling: " + p.getUniqueId());
        collisionDetector.addPackage(p, 0);
    }

    void handlePackage(Pack p, int where) {
        collisionDetector.addPackage(p, where);
    }


    @Override
    public void step() {
        collisionDetector.stepPackages();
        int id =  collisionDetector.getFinishedPacks(length);
        if(id > -1){
            joint.getForwardTo().handlePackage(Game.getGameInstance().getPack(id));
            collisionDetector.removePackage(id);
        }

    }
}
