public class App {
    public static void main(String[] args){
        Jogo PacMan = new Jogo("PacMan", "Puzzle");

        GameEntry g1 = new GameEntry("Pedro", 1500);
        GameEntry g2 = new GameEntry("Deyvisson", 1350);
        GameEntry g3 = new GameEntry("Joao", 1200);
        GameEntry g4 = new GameEntry("Jose", 985);
        GameEntry g5 = new GameEntry("Camila", 750);
        GameEntry g6 = new GameEntry("Gilberto", 1465);
        GameEntry g7 = new GameEntry("Renan", 1145);
        GameEntry g8 = new GameEntry("Caetano", 1000);
        GameEntry g9 = new GameEntry("Haddad", 1450);
        GameEntry g10 = new GameEntry("Ciro", 2000);
        GameEntry g11 = new GameEntry("Marina", 350);
        GameEntry g12 = new GameEntry("Daciolo", 970);
        GameEntry g13 = new GameEntry("Eymael", 890);
        GameEntry g14 = new GameEntry("Boulos", 1335);
        GameEntry g15 = new GameEntry("Alvaro", 920);

        PacMan.addScore(g1);
        PacMan.addScore(g2);
        PacMan.addScore(g3);
        PacMan.addScore(g4);
        PacMan.addScore(g5);
        PacMan.addScore(g6);

        int qtd = PacMan.getNumScores();
        System.out.println(qtd);

        PacMan.addScore(g7);
        PacMan.addScore(g8);
        PacMan.addScore(g9);
        PacMan.addScore(g10);
        PacMan.addScore(g11);
        PacMan.addScore(g12);
        PacMan.addScore(g13);

        qtd = PacMan.getNumScores();
        System.out.println(qtd);

        PacMan.addScore(g14);
        PacMan.addScore(g15);

        System.out.printf("Jogo: %s\nCategoria: %s\nTop 10 Scores: ",PacMan.getNomeJogo(), PacMan.getCategoria());
        System.out.println(PacMan.toString());

        GameEntry teste = PacMan.get(0);
        System.out.printf("Jogador com maior pontuacao no jogo %s: %s",PacMan.getNomeJogo(), teste.toString());

    }
}