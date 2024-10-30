import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    private JButton enterButton = new JButton();
    private JTextField nameInput = new JTextField();
    private String userName;

    public interface onNameSaved{
        void onButtonClick (String nome);
    }

    public onNameSaved listener;

    public MyFrame(onNameSaved listener) {
        this.listener = listener;
        this.setTitle("Dragon Bolla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        ImageIcon treinadorImg = new ImageIcon("src/imagens/treinador.png");
        JLabel label = new JLabel();
        label.setText("Digite seu nome:");
        label.setIcon(treinadorImg);
        label.setBounds(200, 165, 185, 325);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("Roboto Mono", Font.PLAIN, 21));

        nameInput.setBounds(210, 500, 155, 30);
        nameInput.setFont(new Font("Roboto Mono", Font.PLAIN, 16));

        enterButton.setBounds(245, 550, 80, 50);
        enterButton.addActionListener(this);
        enterButton.setText("Entrar");
        enterButton.setFocusable(false);
        enterButton.setFont(new Font("Roboto Mono", Font.PLAIN, 16));
        enterButton.setBackground(Color.LIGHT_GRAY);

        backgroundPanel.add(label);
        backgroundPanel.add(nameInput);
        backgroundPanel.add(enterButton);

        this.add(backgroundPanel);
        this.setVisible(true);
    }


    class BackgroundPanel extends JPanel {
        private Image backgroundImage = new ImageIcon("src/imagens/login-bg.jpg").getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            this.userName = nameInput.getText();
            if(listener != null){
                listener.onButtonClick(userName);
            }
            if (!userName.isEmpty()){
                this.dispose();
            }

        }
    }


}
