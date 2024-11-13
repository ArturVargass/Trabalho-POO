import java.util.ArrayList;
import java.io.Serializable;

public class Treinador implements Serializable{
    private String nome;
    private ArrayList<Bolla> bollasPossuidas;
    private int bollaBallsComum = 6;
    private int bollaBallsRara = 2;
    private int vitorias;
    private int derrotas;


    public Treinador(String nickname){
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

    private void deserdarBolla(Bolla b){
        bollasPossuidas.remove(b);
    }

    private void evoluirBolla(Bolla b){

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

