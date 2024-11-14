import java.io.Serializable;
import java.util.Random;

public class Bill extends Bolla implements Serializable {


    public Bill() {
        super(1, 550, 50, "imagens/Bill.png", "Bill");
    }
    private String nome = "Bill";

    @Override
    public void atacarBasico(Bolla b) {
        Random random = new Random();
        float dano;

        if (random.nextFloat() < 0.40) {
            dano = (float) (this.getPoder() * 2); // Dano crítico
        } else {
            dano =  this.getPoder(); // Dano normal
        }

        b.setHp(Math.max(0, b.getHp() - dano));
    }

    @Override
    public void ataqueEspecial(Bolla b) {
        Random random = new Random();

        float danoBase = this.getPoder() + 35.0f;
        float dano;

        if (random.nextFloat() < 0.50) {

            dano = danoBase * 2.5f;

        } else {

            dano = 0;

        }

        b.setHp(Math.max(0, b.getHp() - dano));
    }

    @Override
    public void atacar(Bolla b) {

        Random random = new Random();

        if (random.nextFloat() < 0.55) {

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