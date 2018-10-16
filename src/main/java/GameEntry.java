import java.io.Serializable;

public class GameEntry implements Serializable {
    private String nome;
    private int score;

    public GameEntry(String n, int s) throws IllegalArgumentException{
        super();
        if(n==null || n=="" || s<0){
            throw new IllegalArgumentException();
        }
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