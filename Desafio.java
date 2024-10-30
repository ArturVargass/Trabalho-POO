public abstract class Desafio {

    private String nome;
    private String explicacao;
    private Boolean realizado;
    private int nivelDesafio;
    private int xpRequerido;
    private int xpRecompensa;


    public abstract void encerrarDesafio();
    public abstract void desafioPerdido();
    public abstract void pararDesafio();

}
