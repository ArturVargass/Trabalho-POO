import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaCapturaBolla extends JFrame implements ActionListener {

    private  JButton bollaBall = new JButton();


    public TelaCapturaBolla() {
        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);

        this.setLocationRelativeTo(null);


        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        ImageIcon bollaImg = new ImageIcon(getClass().getResource("/imagens/Glaufora.png"));

        JLabel bollaIcone =  new JLabel();
        bollaIcone.setIcon(bollaImg);
        bollaIcone.setBounds(195, 294, 185, 425);
        bollaIcone.setHorizontalTextPosition(JLabel.CENTER);
        bollaIcone.setVerticalTextPosition(JLabel.BOTTOM);

        bollaBall.setBounds(245, 620, 100, 50);
        bollaBall.setText("BollaBall");
        bollaBall.setFocusable(false);
        bollaBall.setFont(new Font("Roboto Mono", Font.PLAIN, 16));
        bollaBall.setBackground(Color.LIGHT_GRAY);
        bollaBall.addActionListener(this);


        backgroundPanel.add(bollaIcone);
        backgroundPanel.add(bollaBall);

        this.add(backgroundPanel);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bollaBall) {
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





