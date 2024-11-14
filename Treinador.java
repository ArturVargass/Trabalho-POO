import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;

public class Treinador implements Serializable{
    private String nome;




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


    public void capturarBolla(Bolla b){
        //mostrar na interface a seleção das BollaBalls disponíveis para capturar o BollaBall
        bollasPossuidas.add(b);

        SalveTreinador s = new SalveTreinador(this);
        try {
            s.salvarTreinador();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bollasPossuidas);
    }

    public ArrayList<Bolla> getBollasPossuidas() {
        return bollasPossuidas;
    }

    public void removeBolla(Bolla b){
        this.bollasPossuidas.remove(b);
    }

    public void setBollasPossuidas(ArrayList<Bolla> bollasPossuidas) {
        this.bollasPossuidas = bollasPossuidas;
    }

    public int getBollaBallsComum() {
        return bollaBallsComum;
    }

    public int getBollaBallsRara() {
        return bollaBallsRara;
    }

    public void setBollaBallsComum(int bollaBallsComum) {
        this.bollaBallsComum = bollaBallsComum;
    }

    public void setBollaBallsRara(int bollaBallsRara) {
        this.bollaBallsRara = bollaBallsRara;
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
