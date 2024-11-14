import java.io.Serializable;
import java.util.Random;

public class Datna extends Bolla implements Serializable {


    public Datna() {
        super(1, 180, 30, "imagens/Datna.png");
    }


    @Override
    public void atacarBasico(Bolla b) {

        Random random = new Random();
        float danoBase = this.getPoder() + 15.0f;
        float dano;

        if (random.nextFloat() < 0.10) {
            dano = danoBase * 2;
        } else {
            dano = danoBase;
        }

        b.setHp(Math.max(0, b.getHp() - dano));

    }

    @Override
    public void ataqueEspecial(Bolla b) {

        Random random = new Random();

        float danoBase = this.getPoder();

        float dano;

        if (random.nextFloat() < 0.25) {

            dano = danoBase * 2f;

            this.setHp(this.getHp() + 15);

        } else {

            dano = 0;

        }

        b.setHp(Math.max(0, b.getHp() - dano));

    }

    @Override
    public void atacar(Bolla b) {

        Random random = new Random();

        if (random.nextFloat() < 0.40) {

            ataqueEspecial(b);

        } else {

            atacarBasico(b);

        }

    }

    @Override
    public void defender(float danoRecebido){


    }
}

