import java.util.ArrayList;
import java.util.List;

public class Jogos implements Scores{

    private String nomeJogo;
    private String categoria;
    private List<GameEntry> top10;

    public Jogos(String n, String c){
        nomeJogo = n;
        categoria = c;
        List<GameEntry> top10 = new ArrayList<GameEntry>();
        top10.clear();
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
    public String toString() {
        String str;
        str = "[";
        for(int i = 0; i<top10.size(); i++){
            str = str + top10.get(i).toString() + ", ";
        }
        str = str.substring(0,str.length()-3);
        str = str + "]";
        return str;
    }

    /** Adiciona um novo score se ele for grande o suficiente */
    @Override
    public boolean add(GameEntry e) {
        if(top10.size() < 10){
            for(int i = top10.size()-1; i>=0; i--) {
                if (top10.get(i).getScore() > e.getScore()) {
                    top10.add(i+1, e);
                    return true;
                }
            }
        }
        else if(top10.get(9).getScore() < e.getScore()){
            top10.remove(top10.get(9));
            for(int j = top10.size()-1; j>=0; j--){
                if(top10.get(j).getScore() > e.getScore()){
                    top10.add(j+1,e);
                    return true;
                }
            }
        }
        return false;
    }

    /** Retorna o score na posição i */
    @Override
    public GameEntry get(int i) {
        return top10.get(i);
    }

    /** Retorna a capacidade de coleção */
    @Override
    public int getCapacity() {
        return 10;
    }

    /** Retorna o número de scores armazenados */
    @Override
    public int getNumScores() {
        return top10.size();
    }
}
