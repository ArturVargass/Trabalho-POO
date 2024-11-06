public class Datna extends Bolla{

    public Datna(int nivel, float hp, float poder) {
        super(nivel, hp, poder);
    }



    @Override
    public void atacar(Bolla b) {

    }

    @Override
    public void defender(float danoRecebido) {

    }

    public void cadeirar(Bolla b){

        b.setHp(b.getHp() - (this.getPoder() + 25.0f));

    }

}
