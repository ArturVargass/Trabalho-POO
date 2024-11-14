import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class TelaBatalha extends JFrame implements ActionListener {

    private JButton bollaBallRara = new JButton();
    private JButton bollaBallComum = new JButton();
    private Treinador treinador;
    private Bolla bollaSelecionada;

    public TelaBatalha(Treinador treinador, Bolla bollaSelecionada) {
        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);
        this.treinador = treinador;
        this.bollaSelecionada = bollaSelecionada;

        this.setLocationRelativeTo(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        ImageIcon bollaAdversariaImg = new ImageIcon(getClass().getResource("/imagens/Smilex.png"));
        ImageIcon bollaSelecionadaImg = new ImageIcon(getClass().getResource(bollaSelecionada.getImagePath()));

        JLabel bollaSelecionadaLabel = new JLabel();
        bollaSelecionadaLabel.setIcon(new ImageIcon(invertImage(bollaSelecionadaImg.getImage()))); // Define imagem invertida
        bollaSelecionadaLabel.setBounds(70, 401, 205, 225);
        bollaSelecionadaLabel.setHorizontalTextPosition(JLabel.CENTER);
        bollaSelecionadaLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JLabel bollaAdversaria = new JLabel();
        bollaAdversaria.setIcon(bollaAdversariaImg);
        bollaAdversaria.setBounds(360, 451, 150, 150);
        bollaAdversaria.setHorizontalTextPosition(JLabel.CENTER);
        bollaAdversaria.setVerticalTextPosition(JLabel.BOTTOM);

        backgroundPanel.add(bollaAdversaria);
        backgroundPanel.add(bollaSelecionadaLabel);

        this.add(backgroundPanel);
        this.setVisible(true);
    }

    private BufferedImage invertImage(Image image) {
        // convertendo a imagem para BufferedImage
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        BufferedImage invertedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        //inverte o lado da img na horizontal
        Graphics2D g2d = invertedImage.createGraphics();
        g2d.scale(-1, 1);
        g2d.drawImage(image, -width, 0, null);
        g2d.dispose();

        return invertedImage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bollaBallRara) {
            System.out.println("botão batalha");
        }
    }

    class BackgroundPanel extends JPanel {

        private Image backgroundImage = new ImageIcon(getClass().getResource("/imagens/batalha-bg.png")).getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
    }
}
