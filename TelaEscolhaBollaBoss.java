import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaEscolhaBollaBoss extends JFrame {

    private Treinador treinador;
    private JLabel bollaLabel;
    private int bollaIndex = 0;
    private List<Bolla> bollas;

    public TelaEscolhaBollaBoss(Treinador treinador) {
        this.treinador = treinador;
        this.bollas = treinador.getBollasPossuidas();

        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);


        bollaLabel = new JLabel();
        bollaLabel.setBounds(195, 114, 185, 425);
        bollaLabel.setHorizontalTextPosition(JLabel.CENTER);
        bollaLabel.setVerticalTextPosition(JLabel.BOTTOM);
        updateBollaImage(); // exibe primeiro Bolla
        backgroundPanel.add(bollaLabel);


        JButton nextButton = new JButton(">");
        nextButton.setBounds(450, 350, 50, 50);
        nextButton.setFont(new Font("Arial", Font.PLAIN, 24));
        nextButton.setFocusable(false);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        JButton selectButton = new JButton("Selecionar Bolla");
        selectButton.setBounds(200, 600, 200, 50);
        selectButton.setFont(new Font("Arial", Font.PLAIN, 18));
        selectButton.setFocusable(false);
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bolla bollaSelecionada = bollas.get(bollaIndex);
                TelaBatalhaBoss telaBatalhaBoss = new TelaBatalhaBoss(treinador, bollaSelecionada);
                dispose();
            }
        });

        backgroundPanel.add(nextButton);
        backgroundPanel.add(prevButton);
        backgroundPanel.add(selectButton);

        this.add(backgroundPanel);
        this.setVisible(true);

    }

    private void updateBollaImage() {
        if (bollas.size() > 0) {

            Bolla bolla = bollas.get(bollaIndex);
            String imagePath = bolla.getImagePath().replaceFirst("^/", "");

            System.out.println("Carregando imagem da Bolla: " + imagePath);

            try {
                ImageIcon bollaImage = new ImageIcon(imagePath);
                if (bollaImage.getIconWidth() == -1) {
                    throw new Exception("Imagem não encontrada ou inválida");
                }
                bollaLabel.setIcon(bollaImage);
                bollaLabel.setText(null);
            } catch (Exception e) {
                System.err.println("Erro ao carregar imagem da Bolla: " + e.getMessage());
                bollaLabel.setText("Imagem não encontrada");
                bollaLabel.setIcon(null);
            }
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
