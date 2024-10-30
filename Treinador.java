import java.util.ArrayList;

public class Treinador {

    private ArrayList<Bolla> bollasPossuidas;
    private ArrayList<BollaBall> bollasBallPossuidas;

    private int vitorias;
    private int derrotas;
    
    private String nickname;

    public Treinador(String nickname){
        this.nickname = nickname;
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

    private ArrayList<BollaBall> checarBollaBallsPossuidas(){
        return bollasBallPossuidas;
    }

    private void setNick(String novoNick){
        setNickname(novoNick);
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
