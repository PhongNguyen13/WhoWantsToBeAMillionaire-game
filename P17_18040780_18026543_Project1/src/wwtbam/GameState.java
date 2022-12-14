package wwtbam;

public enum GameState {
    PLAY(1), QUIT(2);
    
    private final int value;

    private GameState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}