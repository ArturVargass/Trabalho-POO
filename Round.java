public class Round {

    private Bolla bolla, inimigo;

    private int contador = 0;

    public Round(Bolla bolla, Bolla inimigo){

        this.bolla = bolla;

        this.inimigo = inimigo;

    }

    public int realizarRound(){

        bolla.atacarBasico(inimigo);
        inimigo.atacarBasico(bolla);

        System.out.println(" round "+ contador + "-------------------------");
        System.out.println("bolla hp: "+bolla.getHp());
        System.out.println("inimigo hp: "+inimigo.getHp());
        System.out.println("-------------------------");

        contador +=1;

        return finalizarBatalha();

    }

    public int finalizarBatalha() {
        if (bolla.getHp() <= 0) {

            return 0;

        } else if(inimigo.getHp() <= 0){

            return 1;

        }

        return 2;

    }

}
