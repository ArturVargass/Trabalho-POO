import java.io.FileWriter;
import java.io.IOException;

public class Main implements MyFrame.onNameSaved{
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyFrame myFrame = new MyFrame(new Main());

        myFrame.show();

    }

    @Override
    public void onButtonClick(String nome) {
        System.out.println("nome: " + nome);
        salvarCSV(nome, 0, 0);
    }

    public void salvarCSV(String nome, int vitorias, int derrotas) {
        try (FileWriter writer = new FileWriter("treinadores.csv", true)) {
            writer.append(nome).append(',').append(String.valueOf(vitorias)).append(',').append(String.valueOf(derrotas)).append('\n');
            System.out.println("Dados salvos no CSV");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}