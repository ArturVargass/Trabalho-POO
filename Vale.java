import java.util.ArrayList;

public abstract class Vale {

    String nome;
    int bollasDisponiveis;
    int desafiosDisponiveis;
    ArrayList<Vila> vilas;

    //viajar para alguma vila do vale
    public abstract void viajarPara(Vila v);

    //sair do vale
    public abstract void sair();



}
