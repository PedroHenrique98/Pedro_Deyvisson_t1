import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
//Necessario dar reimport no Maven Project
public class ScoresSerializacao{
    public static void main(String[] args) {
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

        PacMan.addScore(g1);
        PacMan.addScore(g2);
        PacMan.addScore(g3);
        PacMan.addScore(g4);
        PacMan.addScore(g5);
        PacMan.addScore(g6);
        PacMan.addScore(g7);
        PacMan.addScore(g8);
        PacMan.addScore(g9);
        PacMan.addScore(g10);

        System.out.print("Digite 1 para Arquivo Binario\n");
        System.out.print("Digite 2 para Arquivo Serializado\n");
        System.out.print("Digite 3 para Arquivo CSV\n");
        System.out.print("Digite 4 para Arquivo JSON\n");
        Scanner in = new Scanner(System.in);

        int op = in.nextInt();

        switch (op){

            case 1:
                System.out.println("Gravando arquivo Binario:");

                Path caminhoBinario = Paths.get("ArquivoBinario.bin");
                try(ObjectOutputStream gravador = new ObjectOutputStream(Files.newOutputStream(caminhoBinario))) {
                    gravador.writeUTF(PacMan.toString());
                    System.out.println("...");
                    System.out.println("Arquivo Binario escrito com sucesso! :)");
                } catch(IOException e){
                    System.out.println("...");
                    System.out.println("Falha ao escrever arquivo Binario! :(");
                    e.printStackTrace();
                }

                System.out.println("Lendo arquivo Binario:");

                try (ObjectInputStream lendo = new ObjectInputStream(Files.newInputStream(caminhoBinario))) {
                    String str = lendo.readUTF();
                    System.out.println(str);
                    System.out.println("Arquivo Binario lido com sucesso! :)");
                } catch (IOException e) {
                    System.out.println("Falha ao ler arquivo Binario! :(");
                    e.printStackTrace();

                }
                break;
            case 2:
                System.out.println("Gravando arquivo Serializado:");

                Path caminhoSerializado = Paths.get("ArquivoSerializado.bin");
                try(ObjectOutputStream gravador = new ObjectOutputStream(Files.newOutputStream(caminhoSerializado))) {
                    gravador.writeObject(PacMan);
                    System.out.println("...");
                    System.out.println("Arquivo Serializado escrito com sucesso! :)");
                } catch(IOException e){
                    System.out.println("...");
                    System.out.println("Falha ao escrever arquivo Serializado! :(");
                    e.printStackTrace();
                }

                System.out.println("Lendo arquivo Serializado:");

                try (ObjectInputStream lendo = new ObjectInputStream(Files.newInputStream(caminhoSerializado))) {
                    Jogo jog = (Jogo) lendo.readObject();
                    System.out.println(jog);
                    System.out.println("Arquivo Serializado lido com sucesso! :)");
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Falha ao ler arquivo Serializado! :(");
                    e.printStackTrace();

                }
                break;
            case 3:
                System.out.println("Gravando Arquivo CSV:");
                Path caminhoCSV = Paths.get("ArquivoCSV.csv");
                try(PrintWriter gravador = new PrintWriter(Files.newBufferedWriter(caminhoCSV))) {

                    String str = "Jogador:,Score:";
                    str = str + PacMan.toString();
                    System.out.println("...");
                    str = str.replace('[', ' ');
                    str = str.replace(']',' ');
                    str = str.replace('(', ' ');
                    str = str.replace(')', ' ');
                    str = str.replace("  ", "\n");
                    str = str.replace(" ", "");
                    str = str.replace(",\n", "\n");
                    String strfinal = "Top 10 Scores " + PacMan.getNomeJogo() + ":,\n" + str;
                    gravador.print(strfinal);
                    System.out.println("Arquivo CSV escrito com sucesso!:)");
                } catch (IOException e) {
                    System.out.println("Falha ao escrever arquivo CSV!:(");
                    e.printStackTrace();
                }

                System.out.println("Lendo arquivo CSV:");

                try(BufferedReader entrada = Files.newBufferedReader(caminhoCSV)) {
                    String linha;
                    while ((linha = entrada.readLine()) != null) {
                        System.out.println(linha);
                    }
                    System.out.println("Arquivo CSV lido com sucesso!:)");
                } catch (IOException e) {
                    System.out.println("Falha ao ler arquivo CSV!:(");
                    e.printStackTrace();
                }
                break;

            case 4:
                System.out.println("Gravando Arquivo JSON:");

                Path caminhoJSON = Paths.get("ArquivoJSON.json");
                try(ObjectOutputStream gravador = new ObjectOutputStream(Files.newOutputStream(caminhoJSON))){
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    gravador.writeObject(gson.toJson(PacMan));
                    System.out.println("...");
                    System.out.println("Arquivo JSON escrito com sucesso!:)");
                } catch (IOException e) {
                    System.out.println("...");
                    System.out.println("Falha ao escrever arquivo JSON! :(");
                    e.printStackTrace();
                }

                System.out.println("Lendo arquivo JSON");

                try(BufferedReader entrada = Files.newBufferedReader(caminhoJSON, StandardCharsets.ISO_8859_1)) {
                    String linha;
                    while ((linha = entrada.readLine()) != null) {
                        System.out.println(linha);
                    }

                    System.out.println("Arquivo JSON lido com sucesso!:)");

                } catch (IOException e) {
                    System.out.println("Falha ao ler arquivo JSON!:(");
                    e.printStackTrace();
                }
                break;
            default:
                    System.out.println("Opção não é válida.");

        }
    }
}
