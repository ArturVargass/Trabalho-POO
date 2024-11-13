import java.io.*;

public class TesteSerializacao {
    public static void main(String[] args) {
        Glaufora g = new Glaufora();

        try {
            // Serialização
            FileOutputStream fileOut = new FileOutputStream("glaufora.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(g);
            out.close();
            fileOut.close();

            // Desserialização
            FileInputStream fileIn = new FileInputStream("glaufora.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Glaufora g2 = (Glaufora) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Nome: " + g2.getHp());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}