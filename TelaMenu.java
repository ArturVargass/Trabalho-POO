import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.InputStream;

public class TelaMenu extends JFrame implements ActionListener {

    private JButton botaoProcuraBolla = new JButton();
    private  JButton botaoBatalhar = new JButton();
    private String userName;
    private Treinador treinador;
    private JLabel labelStats = new JLabel();

    public TelaMenu(Treinador treinador) {
        this.treinador = treinador;
        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);

        this.setLocationRelativeTo(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        ImageIcon procurarBollaImg = new ImageIcon(getClass().getResource("/imagens/ProcurarBolla1.png"));
        ImageIcon botaoBatalhaImg = new ImageIcon(getClass().getResource("/imagens/BotaoBatalha.png"));

        botaoBatalhar.setBounds(275, 620, 147, 147);
        botaoBatalhar.setIcon(botaoBatalhaImg);
        botaoBatalhar.setFocusable(false);
        botaoBatalhar.setFont(new Font("Roboto Mono", Font.PLAIN, 16));
        botaoBatalhar.setBackground(Color.LIGHT_GRAY);
        botaoBatalhar.addActionListener(this);

        try (InputStream fontStream = getClass().getResourceAsStream("/Minecraftia.ttf")) {
            if (fontStream == null) {
                throw new IOException("Fonte não encontrada");
            }
            Font minecraftiaFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(20f);

            // Configuração do label com a fonte customizada
            labelStats.setBounds(10, 0, 260, 200);
            labelStats.setFont(minecraftiaFont);
            labelStats.setForeground(Color.BLACK);  // Define o texto em preto
            labelStats.setText("<html>Nome: " + treinador.getNome() +
                    "<br>Vitórias: " + treinador.getVitorias() +
                    "<br>BollaBalls Comuns: " + treinador.getBollaBallsComum() +
                    "<br>BollaBalls Raras: " + treinador.getBollaBallsRara() +
                    "<br>Bollas: " + treinador.getBollasPossuidas().size() +
                    "<br>Derrotas: " + treinador.getDerrotas() +
                    "</html>");
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }



        botaoProcuraBolla.setBounds(42, 375, 233, 223);
        botaoProcuraBolla.setIcon(procurarBollaImg);
        botaoProcuraBolla.setFocusable(false);
        botaoProcuraBolla.setFont(new Font("Roboto Mono", Font.PLAIN, 16));
        botaoProcuraBolla.setBackground(Color.LIGHT_GRAY);
        botaoProcuraBolla.addActionListener(this);

        backgroundPanel.add(botaoBatalhar);
        backgroundPanel.add(botaoProcuraBolla);
        backgroundPanel.add(labelStats);
        this.add(backgroundPanel);
        this.setVisible(true);

        SalveTreinador s = new SalveTreinador(null);
        try {
            Treinador tr = s.carregarTreinador();

            System.out.println(tr.getBollasPossuidas().size());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoProcuraBolla) {

            if(treinador.getBollaBallsComum() == 0 && treinador.getBollaBallsRara() == 0) {
                Exception InGameExceptions;
                try {
                    JOptionPane.showMessageDialog(null, "Você não possui nenhuma BollaBall para capturar!", "PUTS!", JOptionPane.WARNING_MESSAGE);
                    throw new CaptureException();
                } catch (InGameExceptions ex) {
                    throw new RuntimeException(ex);
                }


            }else{

                ProcurandoBolla procurandoBolla = new ProcurandoBolla(this.treinador);
                procurandoBolla.show();
                this.dispose();
            }

        }
        if (e.getSource() == botaoBatalhar) {

            if(treinador.getBollasPossuidas().size() == 0) {

                //CODIGO NENHUMA BOLLA POSSUIDO
                JOptionPane.showMessageDialog(null, "Você não possui nenhum Bolla para batalhar, capture primeiro!", "OH SHIT!", JOptionPane.WARNING_MESSAGE);


            }else{

                //ABRIR TELA BATALHA
                TelaEscolhaBolla telaEscolhaBolla = new TelaEscolhaBolla(this.treinador);
                this.dispose();
            }

            System.out.println("botao batalha");

        }
    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage = new ImageIcon(getClass().getResource("/imagens/menu2-bg.png")).getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        }
    }
}