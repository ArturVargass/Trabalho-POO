import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ProcurandoBolla extends JFrame {

    private JLabel label = new JLabel();
    private String userName;

    public ProcurandoBolla() {
        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);

        this.setLocationRelativeTo(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        /*Font minecraftiaFont = null;
        try {
            minecraftiaFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/mine.ttf")).deriveFont(20f);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(minecraftiaFont);*/


        ImageIcon treinadorImg = new ImageIcon("src/imagens/treinador.png");
        label.setText("");
        label.setIcon(treinadorImg);
        //label.setFont(minecraftiaFont);
        label.setForeground(Color.WHITE);
        label.setBounds(200, 325, 200, 325);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("Arial", Font.PLAIN, 24)); // Fonte, estilo e tamanho

        backgroundPanel.add(label);

        this.add(backgroundPanel);
        this.setVisible(true);

        contagem();

    }




    class BackgroundPanel extends JPanel {
        private Image backgroundImage = new ImageIcon("imagens/procurandobolla-bg.png").getImage();


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


        }
    }



    private void contagem(){



        try {
            Random r = new Random();
            int numero = (r.nextInt(8) + 3)*1000;
            System.out.println(numero);
            Thread.sleep(numero);
            System.out.println("teste finalizado");
            //coloque o código que abrirá a tela de luta contra a bolla

            //AQUI

            //KAKAKAK

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }

}