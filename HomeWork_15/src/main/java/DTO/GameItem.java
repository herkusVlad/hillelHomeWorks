package DTO;

public enum GameItem {
    ROCK("rock"),
    PAPER("paper"),
    SCISSORS("scissors");

    private String value;
    GameItem(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
