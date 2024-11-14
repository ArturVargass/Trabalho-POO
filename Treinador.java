import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;

public class Treinador implements Serializable{
    private String nome;

    public void setBollaBallsRara(int bollaBallsRara) {
        this.bollaBallsRara = bollaBallsRara;
    }

    public void setBollaBallsComum(int bollaBallsComum) {
        this.bollaBallsComum = bollaBallsComum;
    }

    public ArrayList<Bolla> getBollasPossuidas() {
        return bollasPossuidas;
    }

    public void setBollasPossuidas(ArrayList<Bolla> bollasPossuidas) {
        this.bollasPossuidas = bollasPossuidas;
    }

    private ArrayList<Bolla> bollasPossuidas;
    private int bollaBallsComum = 6;
    private int bollaBallsRara = 2;
    private int vitorias;
    private int derrotas;


    public Treinador(String nome){
        this.nome = nome;
        this.bollasPossuidas = new ArrayList<>();
        this.vitorias = 0;
        this.derrotas = 0;
    }


    private void capturarBolla(Bolla b, BollaBall bb){
        //mostrar na interface a seleção das BollaBalls disponíveis para capturar o BollaBall
        if(b.getNivel() >= bb.getNivel()){
            //mostrar captura do bolla
            bollasPossuidas.add(b);
        }
    }

    public void salvarEmArquivo(String caminho) {
        try (FileOutputStream fileOut = new FileOutputStream(caminho);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Bolla> checarBollasPossuidas(){
        return bollasPossuidas;
    }


    public int getBollaBallsComum() {
        return bollaBallsComum;
    }

    public int getBollaBallsRara() {
        return bollaBallsRara;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) { this.nome = nome; }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }


}
