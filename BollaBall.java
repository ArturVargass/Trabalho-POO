import java.util.ArrayList;

public class BollaBall {

    int nivel;

    public BollaBall(int nivel){
        this.nivel = nivel;
    }

    public void verNivel(){
        switch (nivel){
            case 1:
                System.out.println("Você possui uma bola comum");
                break;
            case 2:
                System.out.println("Você possui uma bola rara");
                break;
            case 3:
                System.out.println("Você possui uma bola LENDÁRIA!");
                break;
        }
    }

    public void capturar(Treinador treinador, Bolla alvo){
        if(this.nivel >= alvo.getNivel()){
            //mostrar na interface que o bolla foi capturado com sucesso
        }else{
            //mostrar na interface que o bolla escapou da BollaBall
        }
    }


    public int getNivel(){
        return this.nivel;
    }

}




