package DTO;

public enum GameResult {
    PLAYER("Player"),
    COMPUTER("Computer"),
    DRAW("Draw");

    private String value;

    GameResult(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
