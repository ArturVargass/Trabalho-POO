import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaMenu extends JFrame implements ActionListener {

    private JButton botaoProcuraBolla = new JButton();
    private  JButton botaoBatalhar = new JButton();
    private String userName;

    public TelaMenu() {
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

        botaoProcuraBolla.setBounds(42, 375, 233, 223);
        botaoProcuraBolla.setIcon(procurarBollaImg);
        botaoProcuraBolla.setFocusable(false);
        botaoProcuraBolla.setFont(new Font("Roboto Mono", Font.PLAIN, 16));
        botaoProcuraBolla.setBackground(Color.LIGHT_GRAY);
        botaoProcuraBolla.addActionListener(this);

        backgroundPanel.add(botaoBatalhar);
        backgroundPanel.add(botaoProcuraBolla);

        this.add(backgroundPanel);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoProcuraBolla) {
            ProcurandoBolla procurandoBolla = new ProcurandoBolla();
            procurandoBolla.show();
            this.dispose();
        }
        if (e.getSource() == botaoBatalhar) {
            System.out.println("botao batalha");
        }
    }

    class BackgroundPanel extends JPanel {

        private Image backgroundImage = new ImageIcon(getClass().getResource("/imagens/menu1-bg.png")).getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        }
    }
}





