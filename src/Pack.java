public class Pack {
    private String color;
    private static int UNIQUE_ID = 0;

    private int uid = ++UNIQUE_ID;

    public int getUniqueId() {
        return uid;
    }

    Pack(String color){
        this.color = color;
        Game.getGameInstance().addPack(this);
    }

    public String getColor() {
        return color;
    }
}
