import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaEscolhaBolla extends JFrame {

    private Treinador treinador;
    private JLabel bollaLabel;
    private int bollaIndex = 0;
    private List<Bolla> bollas;

    public TelaEscolhaBolla(Treinador treinador) {
        this.treinador = treinador;
        this.bollas = treinador.getBollasPossuidas();

        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        System.out.println(bollas.get(0).getImagePath());
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);


        bollaLabel = new JLabel();
        bollaLabel.setBounds(200, 300, 200, 200);
        updateBollaImage(); // Exibe a imagem da primeira Bolla
        backgroundPanel.add(bollaLabel);

        // botao de seta para a direita (Próxima Bolla)
        JButton nextButton = new JButton(">");
        nextButton.setBounds(450, 350, 50, 50);
        nextButton.setFont(new Font("Arial", Font.PLAIN, 24));
        nextButton.setFocusable(false);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // aavancar para o proximo item na lista
                if (bollaIndex < bollas.size() - 1) {
                    bollaIndex++;
                    updateBollaImage();
                }
            }
        });


        JButton prevButton = new JButton("<");
        prevButton.setBounds(100, 350, 50, 50);
        prevButton.setFont(new Font("Arial", Font.PLAIN, 24));
        prevButton.setFocusable(false);
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (bollaIndex > 0) {
                    bollaIndex--;
                    updateBollaImage();
                }
            }
        });

        backgroundPanel.add(nextButton);
        backgroundPanel.add(prevButton);

        this.add(backgroundPanel);
        this.setVisible(true);
    }


    private void updateBollaImage() {
        if (bollas.size() > 0) {
            Bolla bolla = bollas.get(bollaIndex);
            ImageIcon bollaImage = new ImageIcon(bolla.getImagePath());
            bollaLabel.setIcon(bollaImage);
        } else {
            bollaLabel.setText("Nenhuma Bolla disponível");
            bollaLabel.setIcon(null);
        }
    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage = new ImageIcon("imagens/escolhaBolla-bg.png").getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
    }
}
