import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.InputStream;

public class TelaEstatisticas extends JFrame implements ActionListener {

    private JButton botaoVoltarMenu = new JButton();

    private String userName;
    private Treinador treinador;
    private JLabel labelStats = new JLabel();

    public TelaEstatisticas(Treinador treinador) {
        this.treinador = treinador;
        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);

        this.setLocationRelativeTo(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        ImageIcon botaoVoltarImg = new ImageIcon(getClass().getResource("/imagens/seta-volta.png"));


        try (InputStream fontStream = getClass().getResourceAsStream("/Minecraftia.ttf")) {
            if (fontStream == null) {
                throw new IOException("Fonte não encontrada");
            }
            Font minecraftiaFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(31f);

            // Configuração do label com a fonte customizada
            labelStats.setBounds(70, 105, 400, 510);
            labelStats.setFont(minecraftiaFont);
            labelStats.setForeground(Color.WHITE);  // Define o texto em preto
            labelStats.setText("<html>Nome: " + treinador.getNome() +
                    "<br><br>Vitórias: " + treinador.getVitorias() +
                    "<br><br>Derrotas: " + treinador.getDerrotas() +
                    "<br><br>BollaBalls Comuns: " + treinador.getBollaBallsComum() +
                    "<br><br>BollaBalls Raras: " + treinador.getBollaBallsRara() +
                    "</html>");
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }



        botaoVoltarMenu.setBounds(10, 10, 60, 60);
        botaoVoltarMenu.setIcon(botaoVoltarImg);
        botaoVoltarMenu.setFocusable(false);
        botaoVoltarMenu.setFont(new Font("Roboto Mono", Font.PLAIN, 16));
        botaoVoltarMenu.setContentAreaFilled(false);
        botaoVoltarMenu.setBackground(new Color(160, 82, 45));
        botaoVoltarMenu.setForeground(new Color(139, 69, 19));
        botaoVoltarMenu.addActionListener(this);

        backgroundPanel.add(botaoVoltarMenu);
        backgroundPanel.add(labelStats);
        this.add(backgroundPanel);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoVoltarMenu) {
            this.dispose();
            TelaMenu telaMenu = new TelaMenu(treinador);

        }
    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage = new ImageIcon(getClass().getResource("/imagens/estatisticas-bg.png")).getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        }
    }
}