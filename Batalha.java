public class Batalha {

    private Bolla bolla;

    private Bolla inimigo;

    public Batalha(Bolla bolla, Bolla inimigo){

        this.bolla = bolla;

        this.inimigo = inimigo;

    }

    public void iniciarBatalha(){

        Round round = new Round(bolla, inimigo);

        while(round.finalizarBatalha() == 2){

            round.realizarRound();

        }



    }

    public void setResultado(Treinador vencedor){

        int v = vencedor.getVitorias();

        vencedor.setVitorias(v + 1);

    }


}
