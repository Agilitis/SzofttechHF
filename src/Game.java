import java.util.LinkedList;

class Game {

    private static Game instance = null;
    LinkedList<Pack> packs;
    private Player player = Player.getInstance();
    private Game(){
        packs = new LinkedList<>();
    }

    static Game getGameInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    public void addPointsToPlayer(int points){
        int playerPoints = player.getPoints();
        player.setPoints(playerPoints+points);
        System.out.println("Added: " + points +" to player. Player now has: "+ player.getPoints());
    }

    public void destroyPack(int packId) {
        System.out.println("Destroyed package: " + packId);
        addPointsToPlayer(-1);
        packs.remove(packId-1);
    }

    public Pack getPack(int packId){
        return packs.get(packId-1);
    }

    void addPack(Pack p){
        packs.add(p);
    }



    void startGame(){
        Map map = Map.getInstance();

    }

    void endGame(){

    }

    Plan createPlan(){
        int red = (int) (Math.random()*100);
        return new Plan();

    }
}
