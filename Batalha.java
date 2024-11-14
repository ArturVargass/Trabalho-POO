import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Batalha {

    private Bolla bolla;
    private Bolla inimigo;

    private float contHpInimigo;
    private float contHpBolla;

    public Batalha(Bolla bolla, Bolla inimigo) {
        this.bolla = bolla;
        this.inimigo = inimigo;
    }

    public void iniciarBatalha(JLabel l1, JLabel l2) {
        Round round = new Round(bolla, inimigo);
        AtomicInteger resultado = new AtomicInteger();

        Timer timer = new Timer(3000, e -> {
            round.realizarRound(l1, l2);
            resultado.set(round.finalizarBatalha());

            if (resultado.get() == 2) {
                ((Timer) e.getSource()).start();
            } else {
                ((Timer) e.getSource()).stop();
                if (resultado.get() == 1) {
                    JOptionPane.showMessageDialog(null, "Você VENCEU a batalha!", "BOYAHHH!", JOptionPane.WARNING_MESSAGE);
                } else if (resultado.get() == 0) {
                    JOptionPane.showMessageDialog(null, "Você PERDEU a batalha.", "Muito ruim namoral", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        timer.start();
    }

    public void setResultado(Treinador vencedor) {
        int v = vencedor.getVitorias();
        vencedor.setVitorias(v + 1);
    }
}