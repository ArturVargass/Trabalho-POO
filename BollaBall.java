import java.io.IOException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Random;

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

        }
    }


    public Boolean capturar(Treinador treinador, Bolla alvo) {

        if(this.nivel == 1){

            treinador.setBollaBallsComum(treinador.getBollaBallsComum() - 1);

        }else if(this.nivel == 2){

            treinador.setBollaBallsRara(treinador.getBollaBallsRara() - 1);

        }

        Random random = new Random();

        int chance;

        if (this.nivel >= alvo.getNivel()) {
            chance = 80;
        } else {
            chance = 15;
        }

        int resultado = random.nextInt(100) + 1;

        if (resultado <= chance) {

            treinador.getBollasPossuidas().add(alvo);

            SalveTreinador s = new SalveTreinador(treinador);

            try {

                s.salvarTreinador();

            } catch (IOException e) {

                throw new RuntimeException(e);

            }

            return true;

        } else {

            return false;

        }

    }



    public int getNivel(){
        return this.nivel;
    }

}



