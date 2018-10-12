public class Jogos implements Scores{

    public Jogos(){

    }
    /** Retorna uma string representando o objeto
     * Formato: [(<name>, <score>), (<name>, <score>) …]
     * Exemplo: [(John, 10), (Carol, 5), (Dan, 3)]
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /** Adiciona um novo score se ele for grande o suficiente */
    @Override
    public boolean add(GameEntry e) {
        return false;
    }

    /** Retorna o score na posição i */
    @Override
    public GameEntry get(int i) {
        return null;
    }

    /** Retorna a capacidade de coleção */
    @Override
    public int getCapacity() {
        return 0;
    }

    /** Retorna o número de scores armazenados */
    @Override
    public int getNumScores() {
        return 0;
    }
}
