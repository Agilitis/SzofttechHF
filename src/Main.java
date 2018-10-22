public class Main {
    public static void main(String[] args) {
        Game game = Game.getGameInstance();
        game.startGame();
        Timer timer = Timer.getInstance();
        timer.start();
    }
}
