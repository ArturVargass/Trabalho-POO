import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaCapturaBolla extends JFrame implements ActionListener {

    private  JButton bollaBallRara = new JButton();
    private  JButton bollaBallComum = new JButton();


    public TelaCapturaBolla(Bolla bollaSorteada) {
        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);

        this.setLocationRelativeTo(null);


        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

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
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bollaBallRara) {
            System.out.println("botao batalha");
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
}




