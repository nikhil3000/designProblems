import services.GamePlayingStrategy.ForwardPlayingGameStrategy;
import services.Game;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(1, 5, 7, 3, new ForwardPlayingGameStrategy());
        game.playGame();
    }
}
