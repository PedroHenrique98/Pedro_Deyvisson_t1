public interface Scores{
    String toString();

    boolean addScore(GameEntry e);

    GameEntry get(int i);

    int getCapacity();

    int getNumScores();
}