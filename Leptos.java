import java.io.Serializable;
import java.util.Random;

public class Leptos extends Bolla implements Serializable {

    private String nome = "Leptos";

    public Leptos() {
        super(1, 200, 30, "imagens/Leptos.png", "Leptos");
    }


    @Override
    public void atacarBasico(Bolla b) {
        Random random = new Random();
        float dano;

        if (random.nextFloat() < 0.35) {
            dano = (float) (this.getPoder() * 2); // Dano crítico
        } else {
            dano =  this.getPoder(); // Dano normal
        }

        b.setHp(Math.max(0, b.getHp() - dano));
    }

    @Override
    public void ataqueEspecial(Bolla b) {
        Random random = new Random();

        float danoBase = this.getPoder() + 15.0f;
        float dano;

        if (random.nextFloat() < 0.30) {

            dano = danoBase * 2.5f;
            this.setHp(this.getHp() + 25);

        } else {

            dano = this.getPoder();

        }

        b.setHp(Math.max(0, b.getHp() - dano));
    }

    @Override
    public void atacar(Bolla b) {

        Random random = new Random();

        if (random.nextFloat() < 0.35) {

            ataqueEspecial(b);

        } else {

            atacarBasico(b);

        }

    }

    @Override
    public void defender(float danoRecebido) {

    }


}
