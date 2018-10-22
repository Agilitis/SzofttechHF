public class Player {
    private static Player instance = null;

    private int points;
    private Player(){
        points = 0;

    }
    public static Player getInstance() {
        if(instance == null){
            instance = new Player();
        }
        return instance;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setSwitch(Switch sw, int position){
        sw.setSwitchSelector(position);
    }
}
