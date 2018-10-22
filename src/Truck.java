public class Truck extends FieldElement implements Steppable{
    static int UNIQUE_ID = 0;
    private String color;
    private int uid = ++UNIQUE_ID;
    private boolean waitingForPackage;
    private int requiredPackages;

    public int getUniqueId() {
        return uid;
    }


    @Override
    void handlePackage(Pack p) {
        System.out.println("Truck @"+uid+": Handling pack!");
        Game game = Game.getGameInstance();
        if(waitingForPackage && requiredPackages !=0){
            if(p.getColor().equals(color)){
                game.addPointsToPlayer(1);
            }else{
                game.addPointsToPlayer(-1);
            }
        }else{
            this.joint.getForwardTo().handlePackage(p);
        }
    }

    Truck(String color, boolean waitingForPackage, int requiredPackages){
        Timer.getInstance().addSteppable(this);
        this.color = color;
        this.waitingForPackage = waitingForPackage;
        this.requiredPackages = requiredPackages;
    }

    @Override
    public void step() {
        int rand = (int)(Math.random()*100)%7;
        if(!waitingForPackage && rand==0){
            Game game = Game.getGameInstance();
            Pack pack = new Pack(randomColor());
            game.addPack(pack);
            joint.getForwardTo().handlePackage(pack);
        }
    }

    private String randomColor(){
        int rand = (int)(Math.random()*100)%4;
        if(rand == 1){
            return "red";
        }else if(rand == 2){
            return "green";
        }
        else{
            return "blue";
        }
    }
}
