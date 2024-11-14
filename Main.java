import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("treinador.txt"))) {
            Treinador treinador = (Treinador) ois.readObject();
            System.out.println("Arquivo treinador.txt encontrado. Carregando dados do treinador...");
            System.out.println(treinador.getNome());
            System.out.println();
            TelaMenu telaMenu = new TelaMenu(treinador);
            telaMenu.show();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo treinador.txt não encontrado. Iniciando novo treinador...");
            MyFrame myFrame = new MyFrame();
            myFrame.show();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//      TelaBatalha telaBatalha = new TelaBatalha();

    }
}
