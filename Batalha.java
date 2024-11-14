public class Batalha {

    private Bolla bolla;
    private Bolla inimigo;



    public Batalha(Bolla bolla, Bolla b2){
        this.bolla = bolla;
        this.inimigo = b2;
    }

    /*public void iniciarBatalha(){

        Round round = new Round();

        while(checarBatalha() == null){

        }

    }*/

    public void finalizarBatalha(){
        //mostrar na interface que a batalha foi encerrada
    }

    public void setVitoria(Treinador vencedor, Treinador perdedor){
        int v = vencedor.getVitorias();
        vencedor.setVitorias(v + 1);
        int d = perdedor.getDerrotas();
        perdedor.setDerrotas(d + 1);
    }

   /* public Bolla checarBatalha(){

        if(this.b1.getHp() == 0 || this.b1.getHp() < 0){

            finalizarBatalha();
            return inimigo;

        }else if(this.inimigo.getHp() == 0 || this.inimigo.getHp() < 0){

            finalizarBatalha();
            return b1;

       }

       return null;

    }*/



}
