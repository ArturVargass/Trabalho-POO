import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class TelaBatalhaBoss extends JFrame implements ActionListener, Batalha.BatalhaListener {

    private Bolla bollaSelecionada;
    private Bolla inimigo;
    JLabel ataqueBolla;
    JLabel ataqueInimigo;
    public TelaBatalhaBoss(Treinador treinador, Bolla bollaSelecionada) {

        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);

        this.setLocationRelativeTo(null);
        this.bollaSelecionada = bollaSelecionada;

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        ImageIcon bollaAdversariaImg;
        ImageIcon bollaSelecionadaImg = new ImageIcon(getClass().getResource(bollaSelecionada.getImagePath()));
        InputStream fontStream = getClass().getResourceAsStream("/Minecraftia.ttf");

        if (fontStream == null) {
            try {
                throw new IOException("Fonte não encontrada");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Font minecraftiaFont = null;

        try {

            minecraftiaFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(13f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(minecraftiaFont);

            ataqueBolla = new JLabel();
            ataqueInimigo = new JLabel();
            ataqueBolla.setFont(minecraftiaFont);
            ataqueInimigo.setFont(minecraftiaFont);

            ataqueBolla.setBounds(40, 101, 270, 100);
            ataqueInimigo.setBounds(340, 101, 300, 100);

            ataqueInimigo.setForeground(Color.WHITE);
            ataqueBolla.setForeground(Color.WHITE);

            backgroundPanel.add(ataqueBolla);
            backgroundPanel.add(ataqueInimigo);

            JLabel bollaSelecionadaLabel = new JLabel();
            bollaSelecionadaLabel.setIcon(new ImageIcon(invertImage(bollaSelecionadaImg.getImage())));
            bollaSelecionadaLabel.setBounds(70, 401, 205, 225);
            bollaSelecionadaLabel.setHorizontalTextPosition(JLabel.CENTER);
            bollaSelecionadaLabel.setVerticalTextPosition(JLabel.BOTTOM);

            ArrayList<Bolla> bollaList = new ArrayList<>();

            bollaList.add(new Smilex());
            bollaList.add(new Leptos());

            Random random = new Random();
            Bolla bollaSorteada = bollaList.get(random.nextInt(bollaList.size()));
            this.inimigo = bollaSorteada;
            bollaAdversariaImg = new ImageIcon(getClass().getResource(bollaSorteada.getImagePath()));

            JLabel bollaAdversaria = new JLabel();
            bollaAdversaria.setIcon(bollaAdversariaImg);
            bollaAdversaria.setBounds(360, 451, 150, 150);
            bollaAdversaria.setHorizontalTextPosition(JLabel.CENTER);
            bollaAdversaria.setVerticalTextPosition(JLabel.BOTTOM);

            backgroundPanel.add(bollaAdversaria);
            backgroundPanel.add(bollaSelecionadaLabel);

            this.add(backgroundPanel);
            this.setVisible(true);

            iniciarBatalha();
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
        /*if (e.getSource() == bollaBallRara) {
            System.out.println("botão batalha");
        }*/
    }

    @Override
    public void onBatalhaFinalizada() {

        try {
            Treinador tr = new SalveTreinador(null).carregarTreinador();
            TelaMenu menu = new TelaMenu(tr);
            menu.show();
            dispose();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    class BackgroundPanel extends JPanel {

        private Image backgroundImage = new ImageIcon(getClass().getResource("imagens/batalhaComTexto-bg.png")).getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
    }

    public void iniciarBatalha(){

        Batalha batalha = new Batalha(bollaSelecionada, inimigo);
        batalha.iniciarBatalha(ataqueBolla, ataqueInimigo);
        batalha.setBatalhaListener(this);

    }

}
