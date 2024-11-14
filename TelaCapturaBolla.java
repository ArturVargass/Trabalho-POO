import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;


public class TelaCapturaBolla extends JFrame implements ActionListener {

    private  JButton bollaBallRara = new JButton();
    private  JButton bollaBallComum = new JButton();
    private Treinador tr;
    private Bolla bollaSorteada;
    private Treinador treinador;

    public TelaCapturaBolla(Bolla bollaSorteada, Treinador treinador) {
        this.bollaSorteada = bollaSorteada;

        this.treinador = treinador;

        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);

        this.setLocationRelativeTo(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        //numero de bollaRaras
        System.out.println(treinador.getBollaBallsRara());



        ImageIcon bollaImg = new ImageIcon(getClass().getResource(bollaSorteada.getImagePath()));
        ImageIcon bollaBallRaraImg = new ImageIcon(getClass().getResource("/imagens/bollaBallRara.png"));
        ImageIcon bollaBallComumImg = new ImageIcon(getClass().getResource("/imagens/bollaBallComum.png"));

        JLabel encontrouLabel = new JLabel("Você encontrou " + bollaSorteada.getClass().getSimpleName());
        encontrouLabel.setFont(new Font("Roboto Mono", Font.BOLD, 24));
        encontrouLabel.setForeground(Color.WHITE);
        encontrouLabel.setBounds(162, 290, 300, 30);

        JLabel bollaIcone =  new JLabel();
        bollaIcone.setIcon(bollaImg);
        bollaIcone.setBounds(195, 294, 185, 425);
        bollaIcone.setHorizontalTextPosition(JLabel.CENTER);
        bollaIcone.setVerticalTextPosition(JLabel.BOTTOM);

        bollaBallRara.setBounds(325, 620, 75, 75);
        bollaBallRara.setFocusable(false);
        bollaBallRara.setContentAreaFilled(false);
        bollaBallRara.setBackground(Color.LIGHT_GRAY);
        bollaBallRara.addActionListener(this);
        bollaBallRara.setIcon(bollaBallRaraImg);

        bollaBallComum.setBounds(185, 620, 75, 75);
        bollaBallComum.setFocusable(false);
        bollaBallComum.setContentAreaFilled(false);
        bollaBallComum.setBackground(Color.LIGHT_GRAY);
        bollaBallComum.addActionListener(this);
        bollaBallComum.setIcon(bollaBallComumImg);


        backgroundPanel.add(bollaIcone);
        backgroundPanel.add(bollaBallRara);
        backgroundPanel.add(bollaBallComum);
        backgroundPanel.add(encontrouLabel);

        this.add(backgroundPanel);
        this.setVisible(true);

        int bballComum = treinador.getBollaBallsComum();
        int bballRara = treinador.getBollaBallsRara();

        //fazer interface para mostrar qtde bballs


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Random random = new Random();

        if (e.getSource() == bollaBallRara) {
            if (this.treinador.getBollaBallsRara() >= 1) {
                // 80% de chance de capturar
                if (random.nextDouble() <= 0.8) {
                    this.treinador.capturarBolla(bollaSorteada);
                    JOptionPane.showMessageDialog(null, "Captura bem-sucedida com BollaBall Rara!", "Resultado da Captura", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Captura falhou com BollaBall Rara.", "Resultado da Captura", JOptionPane.WARNING_MESSAGE);
                }
                this.treinador.setBollaBallsRara(this.treinador.getBollaBallsRara() - 1);
                SalveTreinador s = new SalveTreinador(treinador);
                try {
                    s.salvarTreinador();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Você não possui nenhuma BollaBall rara!", "....", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == bollaBallComum) {
            if (this.treinador.getBollaBallsComum() >= 1) {
                // 50% de chance de capturar
                if (random.nextDouble() <= 0.65) {
                    this.treinador.capturarBolla(bollaSorteada);
                    JOptionPane.showMessageDialog(null, "Captura bem-sucedida com BollaBall Comum!", "Resultado da Captura", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Captura falhou com BollaBall Comum.", "Resultado da Captura", JOptionPane.WARNING_MESSAGE);
                }
                this.treinador.setBollaBallsComum(this.treinador.getBollaBallsComum() - 1);
                SalveTreinador s = new SalveTreinador(treinador);
                try {
                    s.salvarTreinador();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Você não possui nenhuma BollaBall comum!", "....", JOptionPane.INFORMATION_MESSAGE);
            }
            this.dispose();
            TelaMenu telaMenu = new TelaMenu(treinador);
            telaMenu.show();
        }
    }

    class BackgroundPanel extends JPanel {

        private Image backgroundImage = new ImageIcon(getClass().getResource("/imagens/bollaEncontrada-bg.png")).getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        }
    }

    public void capturarBolla(Bolla b, BollaBall bb){

        System.out.println(bb.capturar(tr, b));


    }
}