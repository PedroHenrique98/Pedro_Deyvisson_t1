import java.util.ArrayList;
import java.util.List;

public class Jogo implements Scores{

    private String nomeJogo;
    private String categoria;
    private List<GameEntry> top10;

    public Jogo(String n, String c){
        nomeJogo = n;
        categoria = c;
        top10 = new ArrayList<>();
    }

    public String getNomeJogo(){
        return nomeJogo;
    }

    public String getCategoria(){
        return categoria;
    }

    public List<GameEntry> getTop10(){
        return top10;
    }

    /** Retorna uma string representando o objeto
     * Formato: [(<name>, <score>), (<name>, <score>) …]
     * Exemplo: [(John, 10), (Carol 5), (Dan, 3)]
     */
    public String toString(){
        String str;
        str = "[";
        if(!top10.isEmpty()) {
            for (int i = 0; i < top10.size(); i++) {
                str = str + top10.get(i).toString() + ", ";
            }
            str = str.substring(0, str.length() - 2);
        }

        return str + "]";
    }

    /** Adiciona um novo score se ele for grande o suficiente */
    @Override
    public boolean addScore(GameEntry g){
        if(top10.isEmpty()){
            top10.add(0,g);
        } else if (top10.size() < 10) {
            for (int i = top10.size() - 1; i >= 0; i--) {
                if (top10.get(i).getScore() > g.getScore()) {
                    top10.add(i + 1, g);
                    return true;
                }
            }
            top10.add(0,g);
            return true;
        } else if (top10.get(9).getScore() < g.getScore()) {
            top10.remove(top10.get(9));
            for (int j = top10.size() - 1; j >= 0; j--) {
                if (top10.get(j).getScore() > g.getScore()) {
                    top10.add(j + 1, g);
                    return true;
                }
            }
            top10.add(0,g);
            return true;
        }
        return false;
    }

    /** Retorna o score na posição i */
    @Override
    public GameEntry get(int i){
        if(top10.get(i) != null){
            return top10.get(i);
        }
        return null;
    }

    /** Retorna a capacidade de coleção */
    @Override
    public int getCapacity(){
        return 10;
    }

    /** Retorna o número de scores armazenados */
    @Override
    public int getNumScores(){
        if(top10.isEmpty()) {
            return 0;
        }
        return top10.size();
    }
}
