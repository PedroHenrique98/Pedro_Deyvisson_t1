public interface Scores {
    String toString();

    boolean add(GameEntry e);

    GameEntry get(int i);

    int getCapacity();

    int getNumScores();
}