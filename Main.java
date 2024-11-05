import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            FileReader reader = new FileReader("treinadores.csv");
            System.out.println("existe");
            TelaMenu telaMenu = new TelaMenu();
            telaMenu.show();

        } catch (FileNotFoundException e) {
            System.out.println("não existe");
            MyFrame myFrame = new MyFrame();

            myFrame.show();
        }
    }
}