public class Batalha {

    private Bolla b1;
    private Bolla b2;



    public Batalha(Bolla b1, Bolla b2){
        this.b1 = b1;
        this.b2 = b2;
    }

    public void iniciarBatalha(){

        Round round = new Round();
//
//        while(checarBatalha() == null){
//
//        }

    }

    public void finalizarBatalha(){
        //mostrar na interface que a batalha foi encerrada
    }

    public void setVitoria(Treinador vencedor, Treinador perdedor){
        int v = vencedor.getVitorias();
        vencedor.setVitorias(v + 1);
        int d = perdedor.getDerrotas();
        perdedor.setDerrotas(d + 1);
    }

//    public Bolla checarBatalha(){
//
//        if(this.b1.getHp() == 0 || this.b1.getHp() < 0){
//
//            finalizarBatalha();
//            setVitoria(b2.getTreinador(), b1.getTreinador());
//            return b2;
//
//        }else if(this.b2.getHp() == 0 || this.b2.getHp() < 0){
//
//            finalizarBatalha();
//            setVitoria(b1.getTreinador(), b2.getTreinador());
//            return b1;
//
//        }
//
//        return null;
//
//    }



}
