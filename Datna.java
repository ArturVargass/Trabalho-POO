import java.io.Serializable;

public class Datna extends Bolla implements Serializable {

    public Datna() {
        super(1, 10, 3, "/imagens/Datna.png");
    }



    @Override
    public void atacar(Bolla b) {

    }

    @Override
    public void defender(float danoRecebido) {

    }

    public void cadeirar(Bolla b){

        b.setHp(b.getHp() - (this.getPoder() + 25.0f));

    }

}
