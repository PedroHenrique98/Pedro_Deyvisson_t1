public class GameEntry{
    private String nome;
    private int score;

    public GameEntry(String n, int s){
        nome = n;
        score = s;
    }
    public String getName(){
        return nome;
    }
    public int getScore(){
        return score;
    }

    /** Retorna uma string representando o objeto
     * Formato: (<name>, <score>)
     */
    public String toString() {
        return "(" + nome + ", " + score + ")";
    }
}