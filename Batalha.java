import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


public class Batalha {

    private Bolla bolla;
    private Bolla inimigo;

    private float contHpInimigo;
    private float contHpBolla;

    public interface BatalhaListener {
        void onBatalhaFinalizada();
    }

    private BatalhaListener listener; // Ouvinte da batalha

    public void setBatalhaListener(BatalhaListener listener) {
        this.listener = listener;
    }

    public Batalha(Bolla bolla, Bolla inimigo) {
        this.bolla = bolla;
        this.inimigo = inimigo;
    }

    public void iniciarBatalha(JLabel l1, JLabel l2) {

        Round round = new Round(bolla, inimigo);
        AtomicInteger resultado = new AtomicInteger();

        Timer timer = new Timer(1500, e -> {
            round.realizarRound(l1, l2);
            resultado.set(round.finalizarBatalha());

            if (resultado.get() == 2) {
                ((Timer) e.getSource()).start();
            } else {
                ((Timer) e.getSource()).stop();
                if (resultado.get() == 1) {
                    JOptionPane.showMessageDialog(null, "Você VENCEU a batalha!", "BOYAHHH!", JOptionPane.WARNING_MESSAGE);

                    try {

                        Treinador tr = new SalveTreinador(null).carregarTreinador();

                        tr.setVitorias(tr.getVitorias() + 1);
                        tr.setBollaBallsComum(tr.getBollaBallsComum() + 1);
                        SalveTreinador salveTreinador = new SalveTreinador(tr);
                        salveTreinador.salvarTreinador();

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                } else if (resultado.get() == 0) {

                    JOptionPane.showMessageDialog(null, "Você PERDEU a batalha.", "Muito ruim namoral", JOptionPane.WARNING_MESSAGE);

                    try {
                        Treinador tr = new SalveTreinador(null).carregarTreinador();
                        tr.setDerrotas(tr.getDerrotas() + 1);
                        System.out.println("Antes da remoção: " + tr.getBollasPossuidas());
                        tr.removeBolla(bolla);
                        System.out.println("Depois da remoção: " + tr.getBollasPossuidas());
                        SalveTreinador salveTreinador = new SalveTreinador(tr);
                        salveTreinador.salvarTreinador();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                if(listener != null){
                    listener.onBatalhaFinalizada();
                }

            }
        });

        timer.start();
    }
}