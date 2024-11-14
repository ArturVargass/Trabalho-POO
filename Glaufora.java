import java.io.Serializable;
import java.util.Random;

public class Glaufora extends Bolla implements Serializable {

    public Glaufora() {
        super(1, 200, 30, "imagens/Glaufora.png");
    }
    private String nome = "Glaufora";

    @Override
    public void atacarBasico(Bolla b) {

        Random random = new Random();
        float dano;

        if (random.nextFloat() < 0.15) {
            dano = this.getPoder() * 2; // Dano crítico
        } else {
            dano =  this.getPoder(); // Dano normal
        }

        b.setHp(Math.max(0, b.getHp() - dano));

    }

    @Override
    public void ataqueEspecial(Bolla b) {

        Random random = new Random();

        float danoBase = this.getPoder();
        float dano;

        dano = danoBase * 2.5f;
        this.setHp(this.getHp() + 60);

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


    @Override
    public String getNome() {
        return nome;
    }
}
