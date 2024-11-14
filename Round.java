import javax.swing.*;

public class Round {

    private Bolla bolla, inimigo;
    private int contador = 1;
    private float hpInicialBolla;
    private float hpInicialInimigo;

    public Round(Bolla bolla, Bolla inimigo) {
        this.bolla = bolla;
        this.inimigo = inimigo;
        this.hpInicialBolla = bolla.getHp();
        this.hpInicialInimigo = inimigo.getHp();
    }

    public void realizarRound(JLabel ataqueBollaLabel, JLabel ataqueInimigoLabel) {
        // Armazenar HP antes do ataque
        float hpAntesBolla = bolla.getHp();
        float hpAntesInimigo = inimigo.getHp();

        // Realizar ataques
        bolla.atacar(inimigo);
        inimigo.atacar(bolla);

        // Calcular o dano causado
        float danoCausadoBolla = hpAntesInimigo - inimigo.getHp();
        float danoCausadoInimigo = hpAntesBolla - bolla.getHp();




        // Atualizar os labels com os danos causados
        ataqueBollaLabel.setText(bolla.getNome() + " causou " + danoCausadoBolla + " de dano");
        ataqueInimigoLabel.setText(inimigo.getNome() + " causou " + danoCausadoInimigo + " de dano");

        System.out.println("Round " + contador + "-------------------------");
        System.out.println("Bolla HP: " + bolla.getHp());
        System.out.println("Inimigo HP: " + inimigo.getHp());
        System.out.println("-------------------------");

        contador += 1; // Incrementar após exibição
    }

    public int finalizarBatalha() {
        if (bolla.getHp() <= 0) {

            return 0;

        } else if(inimigo.getHp() <= 0){

            return 1;

        }

        return 2;

    }

    // ... (restante da classe)
}
