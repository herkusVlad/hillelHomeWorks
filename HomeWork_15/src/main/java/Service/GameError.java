package Service;

public class GameError extends RuntimeException{
    public GameError(String message) {
        super(message);
    }
}
