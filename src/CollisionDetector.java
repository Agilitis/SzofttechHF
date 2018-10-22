import java.util.HashMap;
import java.util.Map;

public class CollisionDetector {
    private Map collisionMap;

    CollisionDetector() {

        collisionMap = new HashMap();
    }

    public void addPackage(Pack p, int where) {
        for (Object o : collisionMap.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            if (Math.abs((int) pair.getValue() - where) < 2) {
                Game game = Game.getGameInstance();
                game.destroyPack((int) pair.getKey());
                collisionMap.remove(pair.getKey());
            }
        }
        collisionMap.put(p.getUniqueId(), where);
    }

    public void removePackage(int id){
        collisionMap.remove(id);
    }

    public void stepPackages() {
        for (Object o : collisionMap.entrySet()) {

            Map.Entry pair = (Map.Entry) o;
            pair.setValue((int) pair.getValue() + 1);
        }
    }

    public int getFinishedPacks(int length) {
        for (Object o : collisionMap.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            if((int)pair.getValue()>length){
                return (int)pair.getKey();
            }
        }
        return -1;
    }
}
