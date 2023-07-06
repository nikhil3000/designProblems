import services.ForwardPlayingGame;
import services.Game;

public class Application {

    public static void main(String[] args) {
        Game game = new ForwardPlayingGame(1, 5, 7, 3);
        game.playGame();
    }
}
