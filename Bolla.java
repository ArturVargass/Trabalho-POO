

public abstract class Bolla {

    public void setHp(float hp) {
        this.hp = hp;
    }

    private float hp;
    private float poder;
    private int nivel;
    private String imagePath;

    public Bolla(int nivel, float hp, float poder, String imagePath){
        this.nivel = nivel;
        this.hp = hp;
        this.poder = poder;
        this.imagePath = imagePath;
    }

    public abstract void atacar(Bolla b);

    public abstract void defender(float danoRecebido);

    public float getHp() {
        return hp;
    }

    public int getNivel() {
        return nivel;
    }

    public float getPoder() {
        return poder;
    }


    public String getImagePath() {
        return imagePath;
    }
}

