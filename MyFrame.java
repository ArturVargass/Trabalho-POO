import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class MyFrame extends JFrame implements ActionListener {

    private JButton enterButton = new JButton();
    private JTextField nameInput = new JTextField();
    private String userName;

    public interface onNameSaved{
        void onButtonClick (String nome);
    }

    public onNameSaved listener;

    public MyFrame() {
        this.listener = listener;
        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);

        this.setLocationRelativeTo(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        ImageIcon treinadorImg = new ImageIcon(getClass().getResource("/imagens/treinador.png"));
        try {
            InputStream fontStream = getClass().getResourceAsStream("/Minecraftia.ttf");
            if (fontStream == null) {
                throw new IOException("Fonte não encontrada");
            }
            Font minecraftiaFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(minecraftiaFont);
            JLabel label = new JLabel();
            label.setText("Digite seu nome:");
            label.setIcon(treinadorImg);
            label.setBounds(195, 114, 185, 425);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setFont(minecraftiaFont);

            nameInput.setBounds(210, 500, 155, 30);
            nameInput.setFont(minecraftiaFont);

            enterButton.setBounds(225, 550, 120, 50);
            enterButton.addActionListener(this);
            enterButton.setText("Entrar");
            enterButton.setFocusable(false);
            enterButton.setFont(minecraftiaFont);
            enterButton.setBackground(Color.LIGHT_GRAY);
            backgroundPanel.add(label);
            backgroundPanel.add(nameInput);
            backgroundPanel.add(enterButton);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }






        this.add(backgroundPanel);
        this.setVisible(true);
    }


    class BackgroundPanel extends JPanel {

        private Image backgroundImage = new ImageIcon("imagens/login-bg.jpg").getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            this.userName = nameInput.getText();
            if (!userName.isEmpty()){
                Treinador treinador = new Treinador(userName);
                salvarCSV(treinador);
                this.dispose();
            }
        }
    }

    public void salvarCSV(Treinador treinador) {
        try (FileWriter writer = new FileWriter("treinadores.csv", true)) {
            writer.append(treinador);
            System.out.println("Dados salvos no CSV");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
