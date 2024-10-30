public class Bolla {

    private float hp = 100;

    private int nivel;


    public void atacar(){

    }



    public void defender(float danoRecebido){
        float danoFinal = 0;
        danoFinal -= (danoRecebido*25)/100;
        this.hp -= danoFinal;
    }

}
