import javax.swing.*;
import java.io.IOException;

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
        ataqueBollaLabel.setText("<html>" + bolla.getNome() + " causou " + danoCausadoBolla + " de dano<br>HP: " + bolla.getHp() + "</html>");
        ataqueInimigoLabel.setText("<html>" + inimigo.getNome() + " causou " + danoCausadoInimigo + " de dano<br>HP: " + inimigo.getHp() + "</html>");

        System.out.println("Round " + contador + "-------------------------");
        System.out.println("Bolla HP: " + bolla.getHp());
        System.out.println("Inimigo HP: " + inimigo.getHp());
        System.out.println("-------------------------");

        contador += 1; // Incrementar após exibição
    }

    public int finalizarBatalha() {
        if (bolla.getHp() <= 0) {

            if(bolla instanceof Bill){
                SalveBoss salveBoss = new SalveBoss(bolla);
                try {
                    salveBoss.salvarBoss();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return 0;

        } else if(inimigo.getHp() <= 0){

            if(bolla instanceof Bill){
                SalveTreinador treinadorM = new SalveTreinador(null);
                Treinador tr1 = null;
                try {
                    tr1 = treinadorM.carregarTreinador();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                tr1.setZerado(true);
                try {
                    treinadorM.salvarTreinador();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                SalveBoss salveBoss = new SalveBoss(bolla);
                try {
                    salveBoss.salvarBoss();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    salveBoss.salvarBoss();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return 1;

        }

        return 2;

    }

    // ... (restante da classe)
}
